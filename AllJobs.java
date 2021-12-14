  import java.util.*;
  class Job
  {
   String name;
   int priority;
   int mark;
   Job link;
  }
  class AllJobs
  {

    	static Job start=new Job();
    	public static void main(String args[])
      	{
        	Scanner sc=new Scanner(System.in);
        	String ch="";
        	while(ch!=null)
          	{
            		System.out.print("\n\nSelect:");
            		ch=sc.nextLine();
            		switch(ch)
            		{
              			case "help":
                 			System.out.println("add");
                 			System.out.println("ls");
                 			System.out.println("report");
                 			System.out.println("help");
                 			System.out.println("complete");
					System.out.println("delete");
              			break;
              			case"add":
                 			addtask();

              			break;
				case "delete":
					delete();
				break;	

              			case"ls":
                 			display();
              			break;
              			case"null":
                 			ch=null;
              			break;
              			case"report":
                 			report();
              			break;
              			case"complete":
                 			complete();
              			break;
              			default:
		
        			      System.out.println("\nWrong selection");
             		}
         	}
     	}
	static void delete()
	{
		if(start.link==null)
		{
			System.out.println("Empty list");
			return;
		}
		int pri;
		System.out.println("Enter Priority:");
		Scanner sc =new Scanner(System.in);
		pri=sc.nextInt() ;
		Job p,q=null;
		p=start.link;
		while(p!=null)
		{
			if(p.priority==pri)
			{
				break;
			}
			q=p;
			p=p.link;
		}
		q.link=p.link;
	}
	
     	static void complete()
       	{
       		int pri;
       		Job p=start.link;
       		Scanner sc=new Scanner(System.in);
       		System.out.println("Priority:");
       		pri=sc.nextInt();
       		while(p!=null)
          	{
            		if(p.priority==pri)
              		{
               			 p.mark=1;
              		}
             		p=p.link;
          	}
       		System.out.println("Pending:");
       		p=start.link;
       		int i=1;
       		while(p!=null)
         	{
           		if(p.mark==0)
              		{
                  		System.out.println(i+"."+p.name+"["+p.priority+"]");
                  		i++;
              		}
            		p=p.link;
         	}
       	}
     	static void report()
       	{
        	int c=0,p=0;
         	Job q=start.link;
         	while(q!=null)
           	{
            		if(q.mark==0)
              		{
               			p++;
              		}
          		else
              		{
               			c++;
              		}
          		q=q.link;
           	}
    		System.out.println("Pending:"+p);
    		System.out.println("Complete:"+c);
       	}
    	static void addtask()
       	{
        	Scanner sc=new Scanner(System.in);
        	Job p=start;
        	while(p.link!=null)
           	{
             		p=p.link;
			
           	}
           	p.link=new Job();
           	p=p.link;
           	System.out.print("Priority:");
           	p.priority=sc.nextInt();
           	sc.nextLine();
           	System.out.print("Name:");
           	p.name=sc.nextLine();
		                	
        }
     	static void display()
       	{
         	
		if(start.link==null)
		{
			System.out.println("Empty list");
			return;
		}	
		Job p,q,temp=new Job();
         	int i;
        	for(p=start.link;p.link!=null;p=p.link)
            	{
              		for(q=p.link;q!=null;q=q.link)
                	{
                  		if(p.priority>q.priority)
                     		{
                       			temp.name=p.name;
                       			temp.priority=p.priority;
                       			temp.mark=p.mark;
                       			p.name=q.name;
                       			p.priority=q.priority;
                       			p.mark=q.mark;
                       			q.name=temp.name;
                       			q.priority=temp.priority;
                       			q.mark=temp.mark;
                      		}
                 	}
             	}
		i=1;
		q=start.link;
		while(q!=null)
		{
			System.out.println(i+"."+q.name+" "+"["+q.priority+"]");
			q=q.link;
			i++;
		}		
	   }
 }
















































































































