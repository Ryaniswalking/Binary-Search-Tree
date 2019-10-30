package src;


import java.util.Random;

public class Walker_Driver {

	public static void main(String[] args) 
	{
		//Test Family Tree
		Walker_FamilyTree myFam = new Walker_FamilyTree();
		Person johnDoe = new Person(true, "John Doe", "");
		myFam.add(johnDoe);
		
		Person maryJane = new Person(false, "Mary Jane", "");
		johnDoe.addPartner(maryJane);
		maryJane.addChild (new Person(true, "Jim Doe", johnDoe, maryJane));
		
		Person jennDoe = new Person(false, "Jennifer Doe", johnDoe, maryJane);
		maryJane.addChild(jennDoe);
		
		Person timClark = new Person(true, "Tim Clark", "");
		jennDoe.addPartner(timClark);
		
		Person jessClark = new Person(false, "Jesse Clark", timClark, jennDoe);
		jennDoe.addChild(jessClark);
		
		Person nicoleDoe = new Person(false, "Nicole Doe", "");
		johnDoe.addPartner(nicoleDoe);
		
		Person nickJonah = new Person(true, "Nick Jonah", "");
		nicoleDoe.addPartner(nickJonah);
		nicoleDoe.addChild(new Person(false, "Nancy Jonah", nickJonah, nicoleDoe));
		
		johnDoe.display();
		
		myFam.findRelation(johnDoe, maryJane);
		
		/*public static Integer[] generateDataSet(int size)
		{
			Integer[] bagArray = new Integer[size];
			for (int i=0;i < bagArray.length; i++)
			{
				Random rand = new Random();
				bagArray[i] = rand.nextInt(1000) + 1
			}//end for 
			
			return bagArray;
		}//end generateDataSet
		
		public static void binarySearch(Integer[] bagArray, int searchVal)
		{
			for(int i=0; i<bagArray.length-1; i++)
			{
				
			}//end for
		}//bingarySearch */
	}//end main

}