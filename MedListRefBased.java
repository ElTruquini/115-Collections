/**
 * CSC115 Assignment 2 : Containers
 * MedListRefBased.java
 * Created for use by CSC115 Spring2016 
 * Name: Daniel Olaya Moran
 * ID: V00855054
 * Date: Jan 9, 2016
 * Filename: MedListRefBased.java
 * Details: CSC115 Assignment 2 Collections
 */

/*
 * The MedListRefBased is a list that uses a linked list as
 * the storage for its Medications.
 */
public class MedListRefBased implements List<Medication> {
	
	private MedicationNode head;
	private MedicationNode n;
	private MedicationNode curr;
	private int listCount;


	public MedListRefBased (){
		head = null;
		//head.prev = null;
		listCount = 0 ;
	}
	//Internal method to print content of list
	public void print (){
		System.out.println (":::::PRINTING LIST:::::");
		curr = head;
		while (curr.next != null ){
			System.out.println ("" + curr.item.getName() + " - " + curr+ ",  Prev: " + curr.prev + ",  Next: " + curr.next );
			curr = curr.next;
		}
		System.out.println ("" + curr.item.getName() + " - " + curr+ ",  Prev: " + curr.prev + ",  Next: " + curr.next );


	}

	public void add(Medication k,int index) {
		MedicationNode temp = new MedicationNode (k);
		if (index <0 || index >listCount){
			throw new ListIndexOutOfBoundsException("The index "+index+" is out of bounds.");
		}
		// Adding first item in the list
		if (head == null || index == 0){
			head = temp;
			head.next = null;
			head.prev = null;
			listCount ++;
			//System.out.println ("Adding 1st - head.item : " + head.item);
			//System.out.println ("Adding 1st - head.prev : " + head.prev);
			//System.out.println ("Adding 1st - head.next : " + head.next);
		}
		// Add additional items to the list
		else {
			curr = head;
			int counter = 0;
			while (curr.next != null && counter < index){
				curr = curr.next;
			}
			curr.next = temp;
			temp.prev = curr;
			listCount ++;


		/*Adding to the front of list
			temp.next = head;
			head.prev = temp;
			head = temp;
			listCount ++;
		*/

		/*Traversing to end of the list
			curr = head;
			while (curr.next != null){
				curr = curr.next;
			}
			System.out.println ("Curr after traverse is: " + curr.item);
		*/

		/* Adding to the end of the list
			curr.next = temp;
			temp.prev = curr;
			listCount ++;
		*/


		}
		
		
	}

	public void remove(int index) {
	}

	public Medication get(int index) {
	return null;
	}

	public boolean isEmpty() {
	return true;
	}

	public int size() {
	return 3;
	}

	public void removeAll() {
	}

	public int find(Medication item) {
	return -4;
	}

	public void remove(Medication item) {
	}
/*
	public String toString() {
		//String print = ""+ item.getName + " : " + item.getDosage + " mg" ;
	return "x";
	}
*/
	public static void main(String[] args) {
		// Creating Medication
		Medication m1 = new Medication ("DMT", 200);
		Medication m2 = new Medication ("LSD25", 350);
		Medication m3 = new Medication ("Psilocybin", 450);
		Medication m4 = new Medication ("Modafinil", 75);


		//System.out.println ("M1: " + m1);
		//System.out.println ("M2: " + m2);

		//Creating nodes only items
		MedicationNode dan1 = new MedicationNode (m1);
		MedicationNode dan2 = new MedicationNode (m2);
		System.out.println ("\n\n" );
		/*
		System.out.println ("dan1.item: " + dan1.item);
		System.out.println ("dan2.item: " + dan2.item);
		System.out.println ("dan1: " + dan1);
		System.out.println ("dan2: " + dan2);
		
		//Linking nodes
		System.out.println ("dan1.prev: " + dan1.prev);
		System.out.println ("dan2.prev: " + dan2.prev);
		dan1.next = dan2;
		dan2.prev = dan1;
		System.out.println ("dan1.next (After assignment) : " + dan1.next);
		System.out.println ("dan2.prev (After assignment) : " + dan2.prev);
		*/
		//Constructor
		MedListRefBased list = null;
		try {
			list = new MedListRefBased ();
		} catch (Exception e) {
		System.out.println("Constructor not working");
		e.printStackTrace();	
		return;
		}
		System.out.println ("List: " + list);


		//Add
		list.add (m1,0);
		list.print();
		list.add (m2,0);
		list.print();
		list.add (m3,2);
		list.add (m4,3);

		list.print();


	}		
}

