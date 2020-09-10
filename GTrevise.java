public class GTrevise{
    public static void main(String[] args){
        solve();
    }

    public static class Node{
        int data = 0;
        ArrayList<Node> children = new ArrayList<>();

        Node (int data){
            this.data = data;
        }
    }

    public static void solve(){
        int[] arr={10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 100, -1, 110, -1, -1, 90, -1, -1, 40, 120, 140, -1, 150, -1, -1, -1,-1};
        Node root=constructGTTree(arr);
    }

    public static Node constructGTtree( int[] arr ){
        Stack<Node> st = new Stack<>();
        for( int i=0; i<arr.length-1; i++ ){
            if( arr[i] != -1 ){
                st.push(new Node(arr[i]) );
            }else{
                Node temp = st.pop();
                st.peek().children.addNode(temp);
            }
        }return st.peek();
    }

    public static int height(Node node){
        int h = -1;
        for( Node child : node.children ) h = Math.max(h,height(child));
        return h+1;
    }

    public static int size(Node node){
        int s = 0;
        for( Node child : node.children ) s += size(child);
        return s+1;
    }

    public static int maximum(Node node){
        int max = node.data;
        for( Node child : node.children ) max = Math.max(max, maximum(child));
        return max;
    }

    public static boolean find(Node node, int data){
        if( node.data == data ) return true;
        for( Node child : node.children ) if( find(child,data) ) return true;;
        return false;
    }

    public static boolean NodeToRootPath(Node node,int data,ArrayList<Node> path){
        if( node.data == data ){
            path.add(node);
            return true;
        }
        boolean res = false;
        for( Node child : node.children ){
            res = res || NodeToRootPath(child,data,path);
        }
        if( res ){
            path.add(node);
        }
        return res;
        
    }

    public static void LCA(Node node, int a, int b){
        ArrayList<Node> list1 = new ArrayList<>();
        ArrayList<Node> list2 = new ArrayList<>();

        NodeToRootPath(node,a,list1);
        NodeToRootPath(node,b,list2);

        int i = list1.size()-1;
        int j = list2.size()-1;

        while( i>=0 && j>=0 ){
            if( list1.get(i) != list2.get(j) ) break;
            LCA = list1.get(i);
            i--;
            j--;
        } 
        System.out.println(LCA.data);
    }

    public static void display(Node node){
        StringBuilder sb = new StringBuilder();
        sb.append(node.data + ">");
        for( Node child : node.children) sb.append(child.data + ",");
        System.out.println(sb);

        for( Node child: node.children) display(child);
    }

    public static void zig_zag(Node node){
        Stack<Node> st1 = new Stack<>();
        Stack<Node> st2 = new Stack<>();

        st.push(node);
        boolean flag = true;
        
        while( st1.size() != 0 ){
            int size = st1.size();
            while( size-- > 0 ){
                Node rv = st1.pop();
                System.out.println(rv.data + " " );
            }
            if( flag ){
                for(int i=0; i<rv.children.size(); i++){
                    Node child = rv.children.get(i);
                    st2.push(child);
                }
            }else{
                for(int i=rv.children.size()-1;i>=0; i--){
                    Node child = rv.children.get(i);
                    st2.push(child);
                }
            }
        }

        flag = !flag;
        Stack<Node> temp = st1;
        st1 = st2;
        st2 = temp;
        System.out.println();
    }

    public static Node linearize(Node node){
        if( node.children.size() == 0 ) return node;

        int n = node.children.size();
        Node oTail = linearize(node.children.get(n-2));
        for( int i=n-2; i>=0; i-- ){
            Node tail = linearize(node.children.get(i));

            tail.children.add(node.children.get(i+1));
            node.children.remove(node.children.size()-1);
        }
        return oTail;
    }

    public static void mirror(Node node){
        for( int i=0, j=node.children.size()-1; i<j; i++,j-- ){
            Node helper = node.children.get(i);
            node.children.set( i, node.children.get(j) );
            node.children.set( j, helper );
        }
        for( int i=0; i<node.children.size(); i++ ){
            mirror(node.children.get(i));
        }
    }
}