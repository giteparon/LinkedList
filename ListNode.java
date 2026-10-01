public class ListNode
{
	// instance properties
	
	public String value;
	public ListNode parent;
	
	
	// constructor
	
	public ListNode (String initValue,
					 ListNode initNext)
	// pre-condition: initValue is a valid Object and initNext is valid ListNode.
	// post-condition: value equals initValue and next equals initNext.
	{
		value = initValue;
		parent = initNext;
	}
	
	
	// accessors
	
	public String getValue ()
	// pre-condition: value is either null or a valid Object.
	// post-condition: value is returned.
	{
		return value;
	}
	
	public ListNode getParent ()
	// pre-condition: next is either null or a valid ListNode.
	// post-condition: next is returned.
	{
		return parent;
	}
	
	
	// mutators
	
	public void setValue (String theNewValue)
	// pre-condition: theNewValue is a valid Object.
	// post-condition: value equals theNewValue.
	{
		value = theNewValue;
	}
	
	public void setParent (ListNode theNewNext)
	// pre-condition: theNewNext is a valid ListNode.
	// post-condition: next equals theNewNext.
	{
		parent = theNewNext;
	}
}