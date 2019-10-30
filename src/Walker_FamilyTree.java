

import java.util.ArrayList;

public class Walker_FamilyTree {

	public ArrayList<Person> Families;
	public Person Relative;
	
	//Public method
	//Default constructor
	public Walker_FamilyTree()
	{
		Families = new ArrayList<Person>();
	}
	//Add new person to the family tree
	public boolean add(Person p)
	{
		if (!Families.contains(p))
		{
			Families.add(p);
			return true;
		}//end if 
		return false;
	}//end add
	
	//find the relationship between two people
	public void findRelation(Person p1, Person p2)
	{
		
		//Perform Pre-order traversal of family tree
		//starting with person 1
		Relative = p2;
		//System.out.println(p1.getName());
		//System.out.println(p2.getName());
		ArrayList<Person> personsTraversed = new ArrayList<>();
		boolean relativeFound = preorderTraversal(p1, personsTraversed, false, false, 1);
		System.out.println(p1.getName());	
			for(int i = 0; i < personsTraversed.size(); i++)
			{
				System.out.println(personsTraversed.get(i).DisplayName);
			}// end for 
	}//end findRelation
	
	
	private boolean preorderTraversal(
					Person p
					, ArrayList<Person> personsTraversed
					, boolean isPartner,
					  boolean isChild
					, int level)
	{
		//System.out.println(p.getName());
		/*for (Person nm : personsTraversed)
		{
			System.out.println(nm);
			
		}*/
		
		//recursion Terminating Condition
		if (p == null) return false;
		if (personsTraversed.contains(p)) return false;
		
		personsTraversed.add(p);
		//for (Person nm : personsTraversed)
		//{
			//System.out.println(nm.getName());
			
		//}
	
		String gender = p.IsMale ? " (Male)" : " (Female)";
		String partnerStr = isPartner ? " (Partner)" : "";
		String childStr = isChild ? " (Child)" : "";
		String displayName = "";
		
		for (int i=0; i<level; i++)
		{
			displayName = displayName + "-";
		}//end for 
		
		displayName = displayName + p.Name + gender + partnerStr + childStr;
		p.DisplayName = displayName;
		
		
		
		if (p == Relative)
		{
			// Found Relative
			return true;
		}//end if
		return false;
	}// end preorderTraversal

	
	
}

