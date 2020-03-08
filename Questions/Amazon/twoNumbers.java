public class twoNumbers {

	Node head1,head2,result;
	class Node
	{
		Node next;
		int data;
		public Node(int d)
		{
			this.data=d;
		}
	}
	public void insertNode(int data,int cas)
	{
		Node newNode=new Node(data);
		if(cas==1)
		{
			if(head1==null)
			{
				head1=newNode;
			}
			else
			{
				newNode.next=head1;
				head1=newNode;
			}
		}
		if(cas==2) {
		if(head2==null)
		{
			head2=newNode;
		}
		else
		{
			newNode.next=head2;
			head2=newNode;
		}
		}
	}
	public void printNode(Node head)
	{
		Node curr=head;
		while(curr!=null)
		{
			System.out.print(curr.data+" ");
			curr=curr.next;
		}
		System.out.println();
	}
	public Node addNumbers(Node head1,Node head2)
	{
		Node first=head1,second=head2;
		int sum=0;
		int carry=0;
		Node result=null;
		Node prev=null,temp;
		while(first!=null && second!=null)
		{
			sum=(first!=null?first.data:null)+(second!=null?second.data:null)+carry;
			carry=(sum>=10?1:0);
			sum=sum%10;
			 temp=new Node(sum);
			if(result==null)
				result=temp;
			else
			{
				prev.next=temp;
				
			}
			prev=temp;
			
			if(first!=null)
			{
				first=first.next;
			}
			if(second!=null)
			{
				second=second.next;
			}
		}
		if(carry>0)
		{
			 temp=new Node(carry);
			temp.next=result;
			result=temp;
		}
      return result;
	}
	public static void main(String[]args)
	{
		twoNumbers obj=new twoNumbers();
		obj.insertNode(1,1);
		obj.insertNode(2,1);
		obj.insertNode(3,1);
		obj.insertNode(4,2);
		obj.insertNode(5,2);
		obj.insertNode(6,2);
		obj.printNode(obj.head1);
		obj.printNode(obj.head2);
		obj.result=obj.addNumbers(obj.head1,obj.head2);
		obj.printNode(obj.result);
		
	}
}
