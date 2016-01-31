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
	/*Internal method to print content of list
	public void print (){
		System.out.println ("-------------:::::PRINTING LIST:::::----------");
		curr = head.next;
		while (curr != head){
			System.out.println ("curr: " + curr + " - " + curr.item);
			curr = curr.next;
		}
		System.out.println ("----------:::::END PRINTING LIST:::::---------");
	}
	*/
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
	}

	public void remove(int index) {
		
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
		//System.out.println ("curr is at: " + curr.item + "- index" + index + " REMOVE********************* " );
		curr.prev.next = curr.next;
		curr.next.prev = curr.prev;
		listCount --;
		//System.out.println ("\n" );
		//print ();
	}

	public Medication get(int index) {
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
		return curr.item;
	}

	public boolean isEmpty() {
			if (listCount != 0){
				return false;
			}
		return true;
		}

		public int size() {
		return listCount;
	}

	public void removeAll() {
		head = dummy;
		head.next = dummy; 
		head.prev = dummy;
		listCount = 0;
	}

	public int find(Medication item) {
		int i = 0;
		curr = head.next;
		while (curr != head) {
		//System.out.println ("curr is at: " + curr.item + "- index" + i + " FIND********************* " );
		//System.out.println ("" + curr.item.equals(item) + curr.item + " at i: " + i);
			if (curr.item.equals(item)){
				//System.out.println ("curr: " + curr.item + "- vs. " + item + " " + curr.item.equals(item) + " FIND*********" );
				return i;
			}
			curr = curr.next;
			i++;
		}
		return -1;
	}

	public void remove(Medication item) {
		do {
			if (find (item) != -1){
				remove (find(item));
			} 
		}while (find (item) != -1);	
	}

	public String toString() {
		String print = "---===Begining of List===---\n";
		curr = head.next;
		while (curr != head){
			print = print + "" + curr.item.getName() + " : " + curr.item.getDosage() + " mg" + "\n";
			curr = curr.next;
		}
		print += "---===End of List===---";
		return print;
	}

	public static void main(String[] args) {
		// Creating Medication
		Medication m1 = new Medication ("0- DMT", 200);
		Medication m2 = new Medication ("1- LSD25", 350);
		Medication m3 = new Medication ("2- Psilocybin", 450);
		Medication m4 = new Medication ("3- Modafinil", 75);
		Medication m5 = new Medication ("4- 2CB", 100);
		Medication m6 = new Medication ("5- Cannabinoids", 200);


		//Creating nodes only items
		MedicationNode dan1 = new MedicationNode (m1);
		MedicationNode dan2 = new MedicationNode (m2);
		System.out.println ("\n" );

		//Constructor
		MedListRefBased list = null;
		try {
			list = new MedListRefBased ();
		} catch (Exception e) {
		System.out.println("Constructor not working");
		e.printStackTrace();	
		return;
		}

/*Testing add method
		System.out.println ("Must be true: " + list.isEmpty());
		System.out.println ("Must be 0: " + list.size());
*/
		list.add (m1,0); //dmt
		list.add (m2,1); //lsd
		list.add (m3,2); //psi
		list.add (m4,3); //mod
		list.add (m5,4); //2cb
		list.add (m1,3); //dmt
		list.add (m1,5); //dmt

		//list.print ();
/* 
		//Add method tester
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
		
		//Testing remove method		
		list.remove(1);
		list.remove(0);
		list.remove(2);
		
		//Testing get method
		System.out.println (list.get(0));	
		System.out.println (list.get(1));	
		System.out.println (list.get(2));	
		System.out.println (list.get(3));	
		System.out.println (list.get(4));	
		System.out.println (list.get(10));	

		System.out.println ("Must be false: " + list.isEmpty());
		System.out.println ("Must be 5: " + list.size());

		//Testing Remove all
		list.removeAll();
		list.print();
		
		list.removeAll();
		list.add (m1,0); //dmt
		list.add (m2,1); //lsd
		list.print();
		
		//list.find(m4);
		System.out.println (list.find(m4)); //must return 3
		//list.find(m6);
		System.out.println (list.find(m6)); //must return -1
		
		list.remove(m1);
*/
		//list.remove (m1);	
		//list.remove (3);		
		//list.remove (5);		
	
		System.out.println(list);

		System.out.print("Checking the removeAll method: ");
		list.removeAll();
		System.out.println(""+!list.isEmpty());

		if (!list.isEmpty()) {

			System.out.println("FAILURE");
			return;
		}

	}
}
