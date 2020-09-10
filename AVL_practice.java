public class AVL_practice{
    public static void main(String[] args){
        solve();
    }

    public static class Node{
        int data = 0;
        Node left = null;
        Node right = null;

        int height = 0;
        int bf = 0

        Node(int data){
            this.data = data;
        }
    }

    public static void solve(){
        gg
    }

    public static Node getRotation(Node node){
        updateHtBal(node);
        if( node.bf == 2 ){
            if( node.left.bf == 1){ //ll
                return rightRotation(node);
            }else{ //lr
                node.left = leftRotation(node.left);
                return rightRotation(node);
            }

        }else if(node.bf == -2){
            if( node.right.bf == 1){ //rl
                node.right = rightRotation(node.right);
                return leftRotation(node);
            }else{ //rr
                return leftRotation(node);
            }
        }
    }

    public static void updateHtBal(Node node){
        int lh = -1;
        int rh = -1;
        if( node.left != null ) lh = node.left.height + 1;
        else if( node.right != null ) rh = node.right.height + 1;

        int bal = lh - rh;
        int height = Math.max(lh,rh) + 1;

        node.bf = bal;
        node.height = height;
    }

    public static Node leftRotation(Node A){
        Node B = A.right;
        Node Bleft = B.left;

        B.left = A;
        A.right = Bleft;

        updateHeightBalance(A);
        updateHeightBalance(B);

       return B;
    }

    public static Node rightRotation(Node A){
        Node B = A.left;
        Node Bright = B.right;

        B.right = A;
        A.left = Bright;

        updateHeightBalance(A);
        updateHeightBalance(B);

       return B;
    }

    public static Node addNode(Node node, int data){
        if( node == null ) return new Node(data);
        if( data < node.data ) node.left = addNode(node.left);
        else node.right = addNode(node.right);

        node = getRotation(node);
        return node;
    }

    public static int minimum( Node node ){
        Node curr = node;
        while( curr.left != null ){
            curr = curr.left;
        }
        return curr.data;
    }

    public static Node removeNode(Node node, int data){
        if( node == null ) return null;
        if( node.data < data ) node.right = removeNode(node.right,data);
        else if( node.data > data ) node.left = removeNode(node.left,data);
        else{
            if( node.left == null || node.right == null ){
                return node.left == null ? node.right : node.left;
            }
            int min = minimum
        }
    }
}