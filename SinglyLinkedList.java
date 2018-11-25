
class Link<T> implements Comparable<T> {
     
    private T value;
    private Link<T> nextRef;
     
    public T getValue() {
        return value;
    }
    public void setValue(T value) {
        this.value = value;
    }
    public Link<T> getNextRef() {
        return nextRef;
    }
    public void setNextRef(Link<T> ref) {
        this.nextRef = ref;
    }
    @Override
    public int compareTo(T arg) {
        if(arg == this.value){
            return 0;
        } else {
            return 1;
        }
    }
}

class SinglyLinkedList<T> {
 
    private Link<T> head;
    private Link<T> tail;
     
    public void add(T element){
         
        Link<T> nd = new Link<T>();
        nd.setValue(element);
        System.out.println("Adding: "+element);
        /**
         * check if the list is empty
         */
        if(head == null){
            //since there is only one element, both head and
            //tail points to the same object.
            head = nd;
            tail = nd;
        } else {
            //set current tail next link to new Link
            tail.setNextRef(nd);
            //set tail as newly created Link
            tail = nd;
        }
    }
     
    public void addAfter(T element, T after){
         
        Link<T> tmp = head;
        Link<T> refLink = null;
        System.out.println("Traversing to all Links..");
        /**
         * Traverse till given element
         */
        while(true){
            if(tmp == null){
                break;
            }
            if(tmp.compareTo(after) == 0){
                //found the target Link, add after this Link
                refLink = tmp;
                break;
            }
            tmp = tmp.getNextRef();
        }
        if(refLink != null){
            //add element after the target Link
            Link<T> nd = new Link<T>();
            nd.setValue(element);
            nd.setNextRef(tmp.getNextRef());
            if(tmp == tail){
                tail = nd;
            }
            tmp.setNextRef(nd);
             
        } else {
            System.out.println("Unable to find the given element...");
        }
    }
     
    public void deleteFront(){
         
        if(head == null){
            System.out.println("Underflow...");
        }
        Link<T> tmp = head;
        head = tmp.getNextRef();
        if(head == null){
            tail = null;
        }
        System.out.println("Deleted: "+tmp.getValue());
    }
     
    public void deleteAfter(T after){
         
        Link<T> tmp = head;
        Link<T> refLink = null;
        System.out.println("Traversing to all Links..");
        /**
         * Traverse till given element
         */
        while(true){
            if(tmp == null){
                break;
            }
            if(tmp.compareTo(after) == 0){
                //found the target Link, add after this Link
                refLink = tmp;
                break;
            }
            tmp = tmp.getNextRef();
        }
        if(refLink != null){
            tmp = refLink.getNextRef();
            refLink.setNextRef(tmp.getNextRef());
            if(refLink.getNextRef() == null){
                tail = refLink;
            }
            System.out.println("Deleted: "+tmp.getValue());
        } else {
            System.out.println("Unable to find the given element...");
        }
    }
     
    public void traverse(){
         
        Link<T> tmp = head;
        while(true){
            if(tmp == null){
                break;
            }
            System.out.println(tmp.getValue());
            tmp = tmp.getNextRef();
        }
    }
}
     
class SinglyLinkedListApp {
	
    public static void main(String a[]) {
        SinglyLinkedList<Integer> sl = new SinglyLinkedList<Integer>();
        sl.add(3);
        sl.add(32);
        sl.add(54);
        sl.add(89);
        sl.addAfter(76, 54);
        sl.deleteFront();
        sl.deleteAfter(76);
        sl.traverse();
         
    }
}

