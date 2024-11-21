class Solution {
    boolean dfsCheck(int node,int[][]adj,int pathvis[],int vis[],int check[])
    {
        vis[node]=1;
        pathvis[node]=1;
        check[node]=0;
        int p=adj[node].length;
        int t;
        for(int i=0;i<p;i++)
        {
            t=adj[node][i];
            if(vis[t]==0){
            if(dfsCheck(t,adj,pathvis,vis,check)== true) // cycle detected
            {
                check[node]=0;
                return true;
            }
            }
            else if(pathvis[t]==1)// again cycle detected
            return true;
        }
        check[node] = 1;
        pathvis[node]=0;
        return false;
        }
    
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int v=graph.length;
        int pathvis[]=new int[v];
        int vis[]=new int[v];
        int check[]= new int[v];

        for(int i=0;i<v;i++)
        {
            if(vis[i]==0)
            dfsCheck(i,graph,pathvis,vis,check);
        }
        ArrayList<Integer> ans= new ArrayList<Integer>();
        for(int i=0;i<v;i++)
        {
            if(check[i] == 1)
            ans.add(i);
        }
        return ans;

        
    }
}