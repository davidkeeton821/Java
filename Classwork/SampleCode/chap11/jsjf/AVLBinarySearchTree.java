/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsjf;

import jsjf.exceptions.*;

/**
 *
 * @author Doug Atkinson
 */
public class AVLBinarySearchTree<T> extends LinkedBinarySearchTree<T> {
    
    public AVLBinarySearchTree()
    {
        super();
    }
    
    public AVLBinarySearchTree(T element)
    {
        super(element);
    }
    
    private int height(BinaryTreeNode<T> node)
    {
        if(node == null)
            return 0;
        else
            return node.height;
    }
    
    private int max(int a, int b)
    {
        return (a > b) ? a : b;
    }
    
    // A utility function to right rotate subtree rooted with node
    private BinaryTreeNode<T> rightRotate(BinaryTreeNode<T> y) {
        BinaryTreeNode<T> x = y.left;
        BinaryTreeNode<T> T2 = x.right;
 
        // Perform rotation
        x.right = y;
        y.left = T2;
 
        // Update heights
        y.height = max(height(y.left), height(y.right)) + 1;
        x.height = max(height(x.left), height(x.right)) + 1;
 
        // Return new root
        return x;
    }
    
    // A utility function to left rotate subtree rooted with node
    private BinaryTreeNode<T> leftRotate(BinaryTreeNode<T> x) {
        BinaryTreeNode<T> y = x.right;
        BinaryTreeNode<T> T2 = y.left;
 
        // Perform rotation
        y.left = x;
        x.right = T2;
 
        //  Update heights
        x.height = max(height(x.left), height(x.right)) + 1;
        y.height = max(height(y.left), height(y.right)) + 1;
 
        // Return new root
        return y;
    }
    
    // Get Balance factor of node N
    private int getBalance(BinaryTreeNode<T> node) {
        if (node == null)
            return 0;
 
        return height(node.left) - height(node.right);
    }
    
    private BinaryTreeNode<T> minValueNode(BinaryTreeNode<T> node) {
        BinaryTreeNode<T> current = node;
        
        while(current.left != null)
            current = current.left;
        
        return current;
    }
    
    @Override
    public void addElement(T element)
    {
        if (!(element instanceof Comparable))
            throw new NonComparableElementException("AVLBinarySearchTree");
        
        //BinaryTreeNode<T> node = addElement(element, root);

        //Comparable<T> <)comparableElement = (Comparable<T>)element;
        //BinaryTreeNode<T> newNode = new BinaryTreeNode<T>(element);
        root = addElement(element, root);
        
    }
    
    private BinaryTreeNode<T> addElement(T element, BinaryTreeNode<T> node)
    {
        if(node == null)
            return (new BinaryTreeNode(element));
        
        Comparable<T> comparableElement = (Comparable<T>)element;
        
        if(comparableElement.compareTo(node.getElement()) < 0)
            node.left = addElement(element, node.left);
        else
            node.right = addElement(element, node.right);
        
        // Update height of the ancestor node
        node.height = 1 + max(height(node.left), height(node.right));
        
        // Get the balance factor of this ancestor node to check whether this 
        // node became unbalanced
        int balance = getBalance(node);
        
        // If this node becomes unbalanced, then there are 4 cases
        // Left Left Case
        if( balance > 1 && comparableElement.compareTo(node.left.getElement()) < 0)
            return rightRotate(node);
        
        // Right Right Case
        if( balance < -1 && comparableElement.compareTo(node.right.getElement()) > 0)
            return leftRotate(node);
        
        // Left Right Case
        if(balance > 1 && comparableElement.compareTo(node.left.getElement()) > 0) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        
        // Right Left Case
        if(balance < -1 && comparableElement.compareTo(node.right.getElement()) < 0) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
        
        // return unchanged node
        return node;
            
    }
    
    @Override
    public T removeElement(T targetElement) throws ElementNotFoundException {
        
        //System.out.println("removeElement() in AVLBinarySearchTree");
        
        if(isEmpty())
            throw new ElementNotFoundException("AVLBinarySearchTree");
        
        root = deleteNode(root, targetElement);
        
        return targetElement;
    }
    
    private BinaryTreeNode<T> deleteNode(BinaryTreeNode<T> node, T targetElement) {
        if(node == null)
            return node;
        
        Comparable<T> comparableElement = (Comparable<T>)targetElement;
        
        // If the key to be deleted is smaller than the node's key, then
        // it lies in the left subtree
        if(comparableElement.compareTo(node.getElement()) < 0)
            node.left = deleteNode(node.left, targetElement);
        
        // If the key to be deleted is greater than the node's key,
        // then it lies in the right subtree
        else if(comparableElement.compareTo(node.getElement()) > 0)
            node.right = deleteNode(node.right, targetElement);
        
        // If the key is same as node's, then this is the node to be deleted
        else
        {
            // node with only one child or no child
            if((node.left == null) || (node.right == null))
            {
                BinaryTreeNode<T> temp = null;
                if(temp == node.left)
                    temp = node.right;
                else
                    temp = node.left;
                
                // No child case
                if(temp == null) {
                    temp = node;
                    node = null;
                }
                else    // One child case
                    node = temp;    // Copy the contents of the non-empty child                                  
            }
            else {
                // node with two children: get the inorder successor
                // (smallest in the right subtree)
                BinaryTreeNode<T> temp = minValueNode(node.right);
                
                // Copy the inorder successor's data to this node
                node.element = temp.element;
                
                // Delete the inorder successor
                node.right = deleteNode(node.right, temp.getElement());
            }                
        }
        
        if(node == null)
            return node;
        
       // Update height of the current node
       node.height = max(height(node.left), height(node.right)) + 1;
       
       // Get the balance factor of this node
       int balance = getBalance(node);
       
       // If this node becomes unbalanced, then there are 4 cases
       // Left Left Case
       if(balance > 1 && getBalance(node.left) >= 0)
           return rightRotate(node);
       
       // Left Right Case
       if(balance > 1 && getBalance(node.left) < 0) {
           node.left = leftRotate(node.left);
           return rightRotate(node);
       }
       
       // Right Right Case
       if(balance < -1 && getBalance(node.right) <= 0)
           return leftRotate(node);
       
       // Right Left Case
       if(balance < -1 && getBalance(node.right) > 0) {
           node.right = rightRotate(node.right);
           return leftRotate(node);
       }
       
       return node;
    }
    
    @Override
    public T removeMin() throws EmptyCollectionException {
        T element = findMin();
        removeElement(element);
        return element;
    }
    
    @Override
    public T removeMax() throws EmptyCollectionException {
        T element = findMax();
        removeElement(element);
        return element;
    }
    
    public BinaryTreeNode<T> findNode(T element) {
        if(isEmpty())
            return null;
        return findNode(element, root);
    }
    
    private BinaryTreeNode<T> findNode(T element, BinaryTreeNode<T> node) {
        Comparable<T> comparableElement = (Comparable<T>)element;
        if( node == null)
            return node;
        if(comparableElement.compareTo(node.getElement()) == 0)
            return node;
        else if(comparableElement.compareTo(node.getElement()) < 0)
            return findNode(element, node.left);
        else
            return findNode(element, node.right);
    }
    
    
}
