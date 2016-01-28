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
	private int listCount;
	Medication m1 = new Medication ("test");

	public MedListRefBased (){
		head = null;
	}
	public void add(Medication k,int index) {
	}

	public void remove(int index) {
	}

	public Medication get(int index) {
	return m1;
	}

	public boolean isEmpty() {
	return true;
	}

	public int size() {
	return 1;
	}

	public void removeAll() {
	}

	public int find(Medication item) {
	return -1;
	}

	public void remove(Medication item) {
	}

	public String toString() {
	return "test";
	}

	public static void main(String[] args) {

		System.out.println("INTERNAL TESTING BEGINS:");
		List<Medication> list = null;
		try {
		/*
		 * PROGRAMMER NOTE:
		 * The following line needs to be changed to test the
		 * MedListRefBased class.
		 * Change "ArrayBased" to "RefBased" and run this
		 * tester.  NOTHING ELSE SHOULD BE ALTERED
		 */
			list = new MedListRefBased();
		} catch (Exception e) {
			System.out.println("Constructor not working");
			e.printStackTrace();	
			return;
		}
		// Add some medicine:
		Medication m1 = new Medication("ibuprofen",200);
		list.add(m1,0);
		System.out.print("Adding "+m1+" to an empty list: ");
		if (list.size() != 1) {
			System.out.println("FAILURE");
			return;
		} else {
			System.out.println("SUCCESS");
		}
		/*
		list.add(new Medication("meperidine",100),0);
		list.add(new Medication("acetylsalicylic acid",325),0);
		list.add(new Medication("acetominophen",100),0);
		list.add(new Medication("cimetidine",150),3);
		list.add(new Medication("meperidine",100),0);
		System.out.println("The list should be {meperidine,acetominophen,asa,meperidine,cimetidine}");
		System.out.println(list);
		list.printArray();
		// check to make sure the private shift methods work:
		System.out.println("After sliding everything right from the second spot:");
		list.slideRightFrom(1);
		list.printArray();
		// The list thinks its longer now.	
		list.count++;
		System.out.println("list version: "+list);
		System.out.println("After sliding them back again:");
		list.slideLeftTo(1);
		list.count--;
		list.printArray();
		System.out.println("list version: "+list);

		
		list.remove(new Medication("meperidine",100));
		System.out.println("After removing meperidine:");
		System.out.println(list);
		System.out.println("The number of elements is "+list.size());
		list.removeAll();
		System.out.println("After removing all the elements:");
		System.out.println(list);
		System.out.println("The number of elements is now "+list.size());
	*/

	}
}

