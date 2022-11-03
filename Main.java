import java.util.*;

public class Main
{
	public static void main(String[] args) {
        //make graph
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> graph[] = new ArrayList[n];
        for(int i=0;i<n;i++) graph[i] = new ArrayList<Integer>();
        
        for(int i=0;i<n;i++)
        {
            System.out.println("Enter the no  adj vertex of vertex "+i);
            int m = sc.nextInt();
            for(int j=0;j<m;j++){
                int x = sc.nextInt();
                graph[i].add(x);
            }
        }
        
        //--------------------------------------------------------------------
        Stack<Integer> result = new Stack<Integer>();
        Stack<Integer> temp = new Stack<Integer>();
        
        HashSet<String> hs = new HashSet<String>();
        temp.add(0);
        dfs(0,hs,result,temp,graph);
        if(temp.size()!=0){
	        int val = temp.pop();
	        result.add(val);
	    }
        System.out.println(result);
	}
	
	public static void dfs(int start,HashSet<String> hs,Stack<Integer> result,Stack<Integer>temp,ArrayList<Integer>[] graph)
	{
	    int u = start;
	    ArrayList<Integer> al = graph[u];
	    for(int i=0;i<al.size();i++){
	        int v = al.get(i);
	        if(!hs.contains(u+" "+v) && !hs.contains(v+" "+u)){
	            temp.add(v);
	            hs.add(u+" "+v);
	            hs.add(v+" "+u);
	            dfs(v,hs,result,temp,graph);
	        }
	    }
	    if(temp.size()!=0){
	        int val = temp.pop();
	        result.add(val);
	    }
	}
}
