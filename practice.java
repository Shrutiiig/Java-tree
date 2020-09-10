// self practice

public static class allSolutionPair{
    int height = 0;
    int size = 0;
    boolean find = false;

    Node pred = null, succ = null, prev = null;
}

public static void allSolutions(Node node, int level, int data, allSolutionPair pair){
    if( node == null) return;

    pair.height = Math.max( pair.height, level);
    pair.size++;
    pair.find = pair.find || node.data == 
}

public static Node addNode( Node node, int data ){
    if( node == null ) return new Node(data);

    if( node.data < data ) node.right = addNode(node.right,data);
    else node.left = addNode(node.left,data);

    return node;
}

public static Node removeNode( Node node, int data ){
    if( node == null ) return null;
    if( data < node.data ) node.left = removeNode(node.left,data);
    else if( data > node.data ) node.right = removeNode( node.right,data);
    else{
        if( (node.left == null || node.right == null) return node.left != null ? node.left : node.right )

        Node minEle = minimum( node.right );
        node = minEle;
        node.right = removeNode( node.right, minEle );
    }
    return node;
}

public static int height( Node node ){
    if( node == null ) return 0;
    return Math.max( height(node.left), height( node.right) ) + 1;
}

public static int size(Node node){
    if( node == null ) return 0;
    return size(node.left) + size(node.right) +1;
}

public static boolean find( Node node, int data ){
    if( node == null ) return false;
    if( node.data == data ) return true;
    if(node.data < data) node.right = find(node.right, data);
    else if( node.data > data ) node.left = find(node.left,data); 
    return false;
}

public static boolean find( Node node, int data ){
    
    Node curr = node;
    while( curr != null ){
        if( curr.data == data ) return true;
        else if( curr.data > data ) curr = curr.right;
        else curr = curr.left;
    }

    return false;
}

public static int min(Node node){
    Node curr = node;
    while( curr.left != null ){
        curr = curr.left;
    }
    return curr.data;
}

public static int max(Node node){
    Node curr = node;
    while( curr.right != null ){
        curr = curr.right;
    }
    return curr.data;
}

public Node lca(Node root, Node p, Node q){

    Node curr = root;
    while( curr != null ){
        if( p.data < curr.data && q.data < curr.data ) curr = curr.left;
        else if( p.data > curr.data && q.data > curr.data ) curr = curr.right;
        else return curr;
    }
    return null;
    
}

class BSTIterator {
    Stack<TreeNode> st = new Stack<>();
    public BSTIterator(TreeNode root) {
        pushAllNextElement( root );
    }

    public static void pushAllNextElement(TreeNode root){
        while( root != null ){
            st.push(root);
            root = root.left;
        }
    }
    
    /** @return the next smallest number */
    public int next() {
        TreeNode rv = st.pop();
        pushAllNextElement(rv.right);

        return rv.val;
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return st.size != 0;
    }
}

bTreeToClist{
    Node head = null;
    Node prev = null;
    public void bTreeToClist_(Node root){
        if(root==null) return;
        bTreeToClist_( root.left );

        if( head == null) head = root;
        else{
            root.left = prev;
            prev.right = root;
        }
        prev = root;
        
        bTreeToClist_( root.right );
    }

    Node bTreeToClist(Node root){
        bTreeToClist_(root);
        head.left = prev;
        prev.right = head;

        return head;
    }
}

int idx = 0;
public static Node BSTUsingPreOrder(int[] arr,int lRange, int rRange){

    if(idx >= arr.length || arr[idx] > rRange || arr[idx] < lRange ) return null;
    Node node = new Node(arr[idx++]);

    BSTUsingPreOrder(arr,lRange,node.data);
    BSTUsingPreOrder(arr,node.data,rRange);

    return node;
}

public static Node BSTUsingInOrder(int[] arr,int lRange, int rRange){

    BSTUsingInOrder(arr,lRange,node.data);

    if(idx >= arr.length || arr[idx] > rRange || arr[idx] < lRange ) return null;
    Node node = new Node(arr[idx++]);

    BSTUsingInOrder(arr,node.data,rRange);

    return node;
}

public static Node BSTUsingPostOrder(int[] arr,int lRange, int rRange){

    BSTUsingPostOrder(arr,lRange,node.data);
    BSTUsingPostOrder(arr,node.data,rRange);

    if(idx >= arr.length || arr[idx] > rRange || arr[idx] < lRange ) return null;
    Node node = new Node(arr[idx++]);

    return node;
}

public static int BSTPreOrderHeight(int[] arr,int lRange, int rRange){
    if( idx >= arr.length || arr[idx] > rRange || arr[idx] < lRange ) return -1;
    int ele = arr[idx++];
    int lh = BSTPreOrderHeight(arr,lRange,ele);
    int rh = BSTPreOrderHeight(arr,ele,rRange);

    return Math.max(lh,rh) + 1;
}

public static void PredSucc(Node node,int data){
    Node curr = node;
    Node pred = null, succ = null;
    
    while( curr != null ){
        if( curr.data == data ){
            if( curr.left != null ){
                pred = curr.left;
                while( pred.right != null ) pred = pred.right;
            }
            if( curr.right != null ){
                succ = curr.right;
                while( succ.left != null ) succ = succ.left;
            }
            break;
        }else if( curr.data < data ){
            pred = curr;
            curr = curr.right;
        }else{
            succ = curr;
            curr = curr.left;
        }
    }
}

public static class allSolutionPair{
    int height = 0;
    int size = 0;
    boolean find = false;

    int ceil  = (int)1e8;
    int floor = -(int)1e8;

    Node pred=null, Succ = null, Prev = null;
}
public static void allSolutions(Node node,int level,int data,allSolutionPair pair){
    if( node == null ) return;

    pair.height = Math.max(pair.height, level);
    pair.size++;
    pair.find = pair.find || node.data == data;

    if( node.data > data ) pair.ceil = Math.min(pair.ceil,node.data);
    if( node.data < data ) pair.floor = Math.max(pair.floor,node.data);
    
    if( node.data == data ) pair.pred = prev;
    if( pair.prev != null && pair.prev.data == data ) pair.succ = node;
    pair.prev = node;

    allSolutions(node.left,level+1,data,pair);
    allSolutions(node.right,level+1,data,pair);
}

public static void bfs( Node node ){
    LinkedList<Node> que = new LinkedList<>();
    que.addLast(node);
    while(que.size() != 0){
        Node rvtx = que.removeFirst();
        System.out.println( rvtx.data);

        if( rvtx.left != null ) que.addLast(rvtx.left);
        if( rvtx.right != null ) que.addLast(rvtx.right);
    }
}

public static void bfs( Node node ){
    LinkedList<Node> que = new LinkedList<>();
    que.addLast(node);
    que.addLast(null);

    while( que.size() != null ){
        Node rvtx = que.removeFirst();
        System.out.print(rvtx.data + "");

        if(rvtx.left != null) que.addLast(rvtx.left);
        if(rvtx.right != null) que.addLast(rvtx.right);

        if( que.getFirst() == null ){
            System.out.println()
            que.removeFirst();
            que.addLast(null);
        }
    }
}

public static void bfs( Node node ){
    LinkedList<Node> que = new LinkedList<>();
    que.addLast(node);

    int level = 0;
    while( que.size() != 0 ){
        int size = que.size();
        System.out.print( "level" + level + ":" );
        while( size-- > 0 ){
            Node  rvtx = que.removeFirst();
            System.out.print( rvtx.data + " " );

            if( rvtx.left != null )que.addLast(rvtx.left);
            if( rvtx.right != null ) que.addLast(rvtx.right);
        }
        level++;
        System.out.println();
    }
}

public static void zigzag(Node node){
    Stack<Node> main = new Stack<>();
    Stack<Node> helper = new Stack<>();

    int level = 0;
    main.push(node);
    while( main.size() != 0 ){
        Node cur = main.pop();
        System.out.print(cur.data + " ");

        if( level % 2 == 0 ){
            if( cur.left != null ) helper.push(cur.left);
            if( cur.right != null ) helper.push(cur.right);
        }else{
            if( cur.right != null ) helper.push(cur.right);
            if( cur.left != null ) helper.push(cur.left);
        }
    }
    Stack<Node> temp = new Stack<>();
    main = helper;
    helper = temp;

    System.out.println();
    level++;
}

public static void leftView(Node node){
    LinkedList<Node> que = new LinkedList<>();
    que.addLast(node);

    while(que.size()!=0){
        int size = st.size();
        System.out.print( que.getFirst().data + " ");
        while( size-- > 0 ){
            Node cur = st.removeFirst();

            if( cur.left != null ) que.addLast(cur.left);
            if( cur.right != null ) que.addLast(cur.right);
        }
    }
    
}

public static void rightView(Node node){
    LinkedList<Node> que = new LinkedList<>();
    que.addLast(node);

    while(que.size()!=0){
        int size = que.size();
        Node prev = null;
        while( size-- > 0 ){
            Node cur = que.removeFirst();
            prev = cur;
            if( cur.left != null ) que.addLast(cur.left);
            if( cur.right != null ) que.addLast(cur.right);
        }
        System.out.print( prev.data + " " );
    }
    
}

traversal{

    public static class pair{
        Node node = null;
        boolean selfDone = false;
        boolean leftDone = false;
        boolean rightDone = false;

        pair( Node node, boolean selfDone, boolean leftDone, boolean rightDone){
            this.node = node;
            this.selfDone = selfDone;
            this.leftDone = leftDone;
            this.rightDone = rightDone
        }
    }

    public static void traversal(Node node){
        Stack<pair> st = new Stack<>();

        st.push(pair(node,false,false,false));
        while( st.size() != 0 ){
            Node rvtx = st.peek();

            if( rvtx.leftDone == false ){
                rvtx.leftDone = true;
                if( rvtx.node.left != null ) st.push(pair(node.left,false,false,false));
            }
            else if( rvtx.rightDone == false ){
                rvtx.rightDone = true;
                if( rvtx.node.right != null ) st.push( pair(node.right,false,false,false));
            }
            else if( rvtx.selfDone == false ){
                rvtx.selfDone = true;
                System.out.print( rvtx.node.data + " " );
            }
            else{
                st.pop();
            }
        }
        

    }
}
    int cameras = 0;
    public int minCameraCover(TreeNode root){
        if( root == null ) return 1;

        int lans = minCameraCover(root.left);
        int rans = minCameraCover(root.right);
        if( lans == -1 || rans == -1 ){
            cameras++;
            return 0;
        }
        if( lans == 0 || rans == 0 ) return 1;

        return -1;
    }

    public int minCameraCover_(TreeNode root){
        if( root == null ) return 0;
        if( minCameraCover(root) == -1 ) cameras++;
        return cameras;
    }

    public Node buildTree(int[] preorder, int[] inorder){
        if( preorder.length == 0 ) return null;
        int n = preorder.length;

        return buildTree(preorder,0,n-1,inorder,0,n-1);
    }

    public TreeNode buildTree(int[] preorder, int psi, int pei, int[] inorder, int isi, int iei){
        if( psi > pei ) return null;
        int idx = isi;
    }

    public Node inorderSuccessor(Node node){
        Node succ = null;
        Node curr = node;

        if( curr.right != null ){
            succ = curr.right;
            while( succ.left != null ) succ = succ.left;
            return succ;
        }
        Node curr = node;
        while(curr != null ){
            if( curr.parent != null && curr.parent.left == curr ){
                return curr.parent;
            }
            curr = curr.parent;

        }
    }

}