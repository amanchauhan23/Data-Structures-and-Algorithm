class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {

        HashMap<String, Integer> hm = new HashMap<>();
        DSU dsu = new DSU(accounts.size());

        for(int i = 0; i < accounts.size(); i++){
            for(int j = 1; j < accounts.get(i).size(); j++){
                String key = accounts.get(i).get(j);
                if(!hm.containsKey(key)) hm.put(key, i);
                else dsu.union(hm.get(key), i);
            }
        }

        HashMap<Integer, TreeSet<String>> res = new HashMap<>();
        for(int i = 0; i < accounts.size(); i++){
            int findParent = dsu.find(i);
            if(!res.containsKey(findParent)){
                res.put(findParent, getTreeSet(accounts.get(i)));
            }else{
                MergeSet(res.get(findParent), accounts.get(i));
            }
        }

        List<List<String>> ans = new ArrayList<>();
        for(Map.Entry<Integer, TreeSet<String>> map : res.entrySet()){
            List<String> ls = new ArrayList<>(map.getValue());
            ls.add(0, accounts.get(map.getKey()).get(0));
            ans.add(ls);
        }
        
        return ans;

    }

    public void MergeSet(TreeSet<String> ts, List<String> ls){
        for(int i = 1; i < ls.size(); i++)
            ts.add(ls.get(i));
    }

    public TreeSet<String> getTreeSet(List<String> ls){
        TreeSet<String> ts = new TreeSet<>();
        for(int i = 1; i < ls.size(); i++)
            ts.add(ls.get(i));
        return ts;
    }
}

class DSU{

    int a[];

    DSU(int size){
        a = new int[size];
        for(int i = 0; i < size; i++)
            a[i] = i;
    }

    public void union(int u, int v){
        int uFind = find(u);
        int vFind = find(v);
        if(uFind == vFind) return;
        a[vFind] = uFind;
    }

    public int find(int index){
        if(a[index] == index) return index;
        else return find(a[index]);
    }
}
