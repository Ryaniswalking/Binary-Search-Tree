
import java.util.ArrayList;
public class Person 
{
	//Public Data Members
	public String Name;
	public String DateOfBirth;
	public boolean IsMale;
	public Person mother;
	public Person father;
	public ArrayList<Person> Partners;
	public ArrayList<Person> Children;
	public String DisplayName;
	
	public Person()
	{
		Init(false, "", "1/1/1900");
	}
	public Person(boolean isMale, String name, String dateOfBirth)
	{
		Init(isMale, name, dateOfBirth);
	}
	public Person(boolean isMale, String name, Person father, Person mother)
	{
		Init(isMale, name, "");
		addParent(father, false);
		addParent(mother, true);
	}
	private void Init(boolean isAMale, String name, String dateOfBirth)
	{
		Name = name;
		DateOfBirth = dateOfBirth;
		IsMale = isAMale;
		Partners = new ArrayList<Person>();
		Children = new ArrayList<Person>();
	}
	public void addParent(Person parent, boolean isMother)
	{
		if(isMother)
		{
			this.mother = parent;
		}//end if
		else
		{
			this.father = parent;
		}//end else
	}//end addParent
	
	public boolean addPartner(Person partner)
	{
		boolean result = false;
		if(!Partners.contains(partner))
		{
			Partners.add(partner);
			result = true;
		}//end if
		if (!partner.Partners.contains(this))
		{
			partner.Partners.add(this);
		}//end if
		return result;
	}//end addPartner
	public boolean addChild(Person child)
	{
		if(!Children.contains(child))
		{
			Children.add(child);
			return true;
		}//end if
		return false;
	}//end addChild
	public void display()
	{
		// something
		//somthing
		ArrayList<Person> personsTraversed = new ArrayList<>();
		preorderDisplay(this, personsTraversed, false, false, 0);
	}//end display
	public void preorderDisplay(Person p, ArrayList<Person> personsTraversed
									, boolean isPartner, boolean isChild, int level)
	{
		//something
		//something
		if (p==null) return;
		if (personsTraversed.contains(p)) return;
		
		personsTraversed.add(p);
		
		
		String gender = p.IsMale ? " (Male)" : " (Female)";
		String partnerStr = isPartner ?" (Partner)" : "";
		String childStr = isChild ? " (Child)" : "";
		
		for(int j=0;j<level;j++)
		{
			System.out.print("-");
		}//end for
		
		System.out.println(p.Name + gender + partnerStr + childStr);
		
		for (int i = 0; i<p.Partners.size(); i++)
		{
			Person partner = p.Partners.get(i);
			preorderDisplay(partner, personsTraversed, true, false, level + 1);
		}//end for
		
		for (int i=0;i<p.Children.size(); i++)
		{
			Person child = p.Children.get(i);
			preorderDisplay(child, personsTraversed, false, true, level + 1);
		}//end for
	}//end preorderDisplay
	public String getName()
	{
		return Name;
	}
	
}





