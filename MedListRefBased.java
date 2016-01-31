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
	private MedicationNode dummy;
	private MedicationNode curr;

	private int listCount;


	public MedListRefBased (){
		dummy = new MedicationNode (null);
		head = dummy;
		head.next = dummy; 
		head.prev = dummy;
		listCount=0;

	}
	//Internal method to print content of list
	public void print (){
		System.out.println ("-------------:::::PRINTING LIST:::::----------");
		curr = head.next;
		while (curr != head){
			System.out.println ("curr: " + curr + " - " + curr.item);
			curr = curr.next;
		}
		System.out.println ("----------:::::END PRINTING LIST:::::---------");

	}

	public void add(Medication k,int index) {
		MedicationNode newNode = new MedicationNode (k);
		
		if (index <0 || index >listCount){
			throw new ListIndexOutOfBoundsException("The index "+index+" is out of bounds.");
		}
		curr = head.next;
		int i = 0;
		//System.out.println ("head is at: " + head.item + "-" + head + " ********************* " );
		while ((curr != head) && (i < index)) {
			curr = curr.next;
			i++;
		}
		//System.out.println ("curr is at: " + curr.item + "-" + curr + " ********************* " );
		newNode.next = curr;
		newNode.prev = curr.prev;
		curr.prev = newNode;
		newNode.prev.next = newNode;// How does this work??????

		listCount ++;
		System.out.println ("\n" );
		print ();

/*Traverse with index tester
		curr = head.next;
		i = 0;
		System.out.println ("head is at: " + head.item + "-" + head + " ********************* " );
		while ((curr != head) && (i < index)) {
			curr = curr.next;
			i++;
		}
		System.out.println ("curr is at: " + curr.item + " - " + curr+ ", at index - " + index + " ********************* " );
*/


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
		Medication m1 = new Medication ("0- DMT", 200);
		Medication m2 = new Medication ("1- LSD25", 350);
		Medication m3 = new Medication ("2- Psilocybin", 450);
		Medication m4 = new Medication ("3- Modafinil", 75);
		Medication m5 = new Medication ("4- 2CB", 100);

		//Creating nodes only items
		MedicationNode dan1 = new MedicationNode (m1);
		MedicationNode dan2 = new MedicationNode (m2);
		System.out.println ("\n" );
		/*

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

		list.add (m1,0); //dmt
		list.add (m2,1); //lsd
		list.add (m3,2); //psi
		list.add (m4,3); //mod
		list.add (m5,4); //2cb

		/*Add method tester
		list.add (m1,0); //dmt
		list.add (m2,1); //lsd
		list.add (m3,2); //psi
		list.add (m4,3); //mod
		list.add (m5,4); //2cb
		System.out.println ("Expected result: 0,1,2,3,4");
		
		list.add (m1,0); //dmt
		list.add (m2,0); //lsd
		list.add (m3,0); //psi
		list.add (m4,0); //mod
		list.add (m5,0); //2cb
		System.out.println ("Expected result: 4,3,2,1,0");

		list.add (m1,0); //0.dmt
		list.add (m2,1); //1.lsd
		list.add (m3,1); //2.psi
		list.add (m4,2); //3.mod
		list.add (m5,0); //4.2cb
		System.out.println ("Expected result: 4,0,2,3,0");
		*/
	}		
}

