/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4;
import java.util.*;

/**
 *
 * @author David
 */
public class WordData implements Comparable<WordData> {
    private final String word;
    private final List<Integer> list;
    
    public WordData()   {
        word = null;
        list = new ArrayList<>();
    }
    
    public WordData(String word, Integer lineNum)   {
        this.word = word;
        list = new ArrayList<>();
        list.add(lineNum);
    }
    
    public WordData(WordData wordData)   {
        this.word = wordData.word;
        list = new ArrayList<>();
        for(Integer line : wordData.list)   {
            this.list.add(line);
        }
    }
    
    public String getWord()   {
        return word;
    }
    
    public List<Integer> getList()   {
        return list;
    }
    
    public void addToList(int lineNum)   {
        if(!list.contains(lineNum))
            this.list.add(lineNum);
    }
    
    @Override
    public int compareTo(WordData other)   {
        
        return this.word.compareTo(other.getWord());
        
    }  
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((word == null) ? 0 : word.hashCode());
                
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final WordData other = (WordData) obj;
        if (!Objects.equals(this.word, other.word)) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString()   {
        String str = "";
        
        str += this.getWord() + ": ";
        for (int i = 0; i < this.list.size(); i++)   {
            str += this.list.get(i).toString();
            if((i + 1) != this.list.size())
                str += ", ";
        }
        
        return str;
    }
}
