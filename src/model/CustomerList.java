package model;

public class CustomerList{
    private Node first; //first==start

    public void add(Customer customer){
        Node n1=new Node(customer);
        if(first==null){
            first=n1;
        }else{
            Node lastNode=first;
            while(lastNode.next!=null){
                lastNode=lastNode.next;
            }
            lastNode.next=n1;
        }
    }
    public Customer[] toArray(){
        Customer[] customerArray=new Customer[size()];
        Node temp=first;
        for(int i=0; temp!=null; i++){
            customerArray[i]=temp.customer;
            temp=temp.next;
        }
        return customerArray;
    }
    private boolean isValidIndex(int index){
        return index>=0 && index<=size();
    }
    public void add(int index, Customer customer){
        Node n1=new Node(customer);
        if(isValidIndex(index)){
            if(index==0){
                n1.next=first;
                first=n1;
            }else{
                Node temp=first;
                for(int i=0; i<index-1; i++){
                    temp=temp.next;
                }
                n1.next=temp.next;
                temp.next=n1;
            }
        }
    }
    public void remove(int index){
        if(isValidIndex(index)){
            if(index==0){
                first=first.next;
            }else{
                Node temp=first;
                for(int i=0; i<index-1; i++){
                    temp=temp.next;
                }
                temp.next=temp.next.next;
            }
        }
    }
    public void remove(Customer customer){
        remove(indexOf(customer));
    }
    public void remove(int startIndex, int endIndex){

    }
    public int indexOf(Customer customer){
        Node temp=first;
        int index=-1;
        while(temp!=null){
            index++;
            if(temp.customer.equals(customer)){
                return index;
            }
            temp=temp.next;
        }
        return -1;
    }
    public boolean contains(Customer customer){
        return indexOf(customer)!=-1;
    }
    public Customer get(int index){
        if(isValidIndex(index)){
            if(index==0){
                return first.customer;
            }else{
                Node temp=first;
                for(int i=0; i<index; i++){
                    temp=temp.next;
                }
                return temp.customer;
            }
        }
        return null;
    }
    public void printList(){
        System.out.println(toString());
    }
    public String toString(){
        String list="[";
        Node temp=first;
        while(temp!=null){
            list+=temp.customer+", "; //temp.customer.toString()
            temp=temp.next;
        }
        return isEmpty()? "[empty]":list+"\b\b]";
    }
    public void clear(){
        first=null;
    }
    public boolean isEmpty(){
        return first==null;
    }
    public int size(){
        int count=0;
        Node temp=first;
        while(temp!=null){
            count++;
            temp=temp.next;
        }
        return count;
    }
    //------------Inner class----------------
    private class Node{
        private Customer customer;
        private Node next;

        Node(Customer customer){this.customer=customer;}
    }
    //--------------------------------------
}
