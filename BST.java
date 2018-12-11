/******************************************************
 * BST ADT.
 * Supported operations:
 * Insert
 * Delete
 * Find
 * Min
 * Max
 * Depth
 * Print
 ******************************************************/
// ARIEF HAKIM ASKAR
// NATIG KURBANOV
public class BST{
  private BSTNode root;     
  private int noOfNodes;     

  /*******************************************************
   * Constructor: Initializes the BST
   *******************************************************/
  public BST(){root=null; noOfNodes=0;}

  /*******************************************************
   * Returns a pointer to the root of the tree
   *******************************************************/
  public BSTNode Root(){return root;}

  /*******************************************************
   * Returns the number of nodes in the tree
   *******************************************************/
  public int NoOfNodes(){return noOfNodes;}

  /*******************************************************
   * Inserts the key into the BST. Returns a pointer to
   * the inserted node
   *******************************************************/
  public BSTNode Insert(int key){
      
      BSTNode t = new BSTNode(key); 
      t.key = key; 
      t.left = t.right = null;
      
      BSTNode p2 = null; 
      BSTNode p = root;
      while (p != null){
        p2 = p;
        if (key == p.key){ p.count++; noOfNodes--; break;}
        else if (key < p.key)  p = p.left;
        else p = p.right;
      }
      
      if (root == null) root = t;
      else if (key < p2.key) p2.left = t;
      else  if(key>p2.key) p2.right = t;
     noOfNodes++;
     return p;
  } //end-Insert

  /*******************************************************
   * Deletes the key from the tree (if found). Returns
   * 0 if deletion succeeds, -1 if it fails
   *******************************************************/
  public int Delete(int key){
    // Fill this in
      BSTNode node;
      BSTNode node2=null;
      BSTNode nodex;
      BSTNode node3=null;
      node=root;
      
      if(root==null){
             return -1;
          }
      else if(root.key==key){
          if(root.left!=null&&root.right!=null){
              nodex=root.right;
              while(nodex.left!=null){
                  node3=nodex;
                  nodex=nodex.left;
              }
              root.key=nodex.key;
              if(node3==null){
                  node.right=nodex.right;
              }
              else{
              if(nodex.right!=null)
                  node3.left=nodex.right;
              else
              node3.left=null;
              
              }
              } 
          else if(root.right!=null&&root.left==null){
              root=root.right;
              
              }
          else if(root.left!=null&&root.right==null){
              root=root.left;
              
              }
          else {
              root=null;     
          }
          noOfNodes--;
          return 0;
      }
      else{ 
          while(node!=null){
      
          if(node.key==key){
              
              if(node.left!=null&&node.right!=null){
                  nodex=node.right;
                  while(nodex.left!=null){
                      node3=nodex;
                      nodex=nodex.left;
                  }
                  
                  node.key=nodex.key;
                  if(node3==null){
                      node.right=nodex.right;
                  }
                  else{
                  if(nodex.right!=null){
                      node3.left=nodex.right;
                  nodex=null;
                  }
                  else{
                  node3.left=null;
                      nodex=null;
                  }
                  }
                  } 
              else if(node.right!=null&&node.left==null){
                  if(node2.left.key==node.key)
                  node2.left=node.right;
                  else
                      node2.right=node.right;
                  
                  }
              else if(node.left!=null&&node.right==null){
                  if(node2.left.key==node.key)
                      node2.left=node.left;
                      else
                          node2.right=node.left;  
                  }
              else {
                  if(node2.left.key==node.key)
                      node2.left=null;
                      else
                          node2.right=null;
              }
              noOfNodes--;
              return 0;
              }
          else if(node.key<key){ 
              node2=node;
              node=node.right;
          
          }
          else {
              node2=node;
              node=node.left;
          
          }
      }
          return -1;
      }
          
         } //end-Delete

  /*******************************************************
   * Searches the BST for a key. Returns a pointer to the
   * node that contains the key (if found) or NULL if unsuccessful
   *******************************************************/
  public BSTNode Find(int key){
      
      BSTNode d = new BSTNode(key);
      d=root;
      while(d!=null){
          if(d.key==key) return d;
          else if(d.key<key) d=d.right;
          else d=d.left;
      }
    return null;
  } //end-Find

  /*******************************************************
   * Returns a pointer to the node that contains the minimum key
   *******************************************************/
  public BSTNode Min(){
      BSTNode td;
      BSTNode td2 = null;
      if(root==null) return null;
      td=root;
      while(td!=null){
          td2=td;
          td=td.left;   
      }
    
    return td2;
  } //end-Min

  /*******************************************************
   * Returns a pointer to the node that contains the maximum key
   *******************************************************/
  public BSTNode Max(){
      BSTNode td;
      BSTNode td2 = null;
      if(root==null) return null;
      td=root;
      while(td!=null){
          td2=td;
          td=td.right;  
      }
    return td2;
      
  } //end-Max

  /*******************************************************
   * Returns the depth of tree. Depth of a tree is defined as
   * the depth of the deepest leaf node. Root is at depth 0 
   *******************************************************/
  public int Depth(){
    int i=-1;
      BSTNode node;
      BSTNode node2;
      node=root;
      node2=null;
      while(node!=null){
          node2=node;
          if(node2.left==null && node2.right!=null){
              node=node.right;
              i++;      
          }
          else if(node2.right==null && node2.left!=null){
              node=node.left;
              i++;   
          }
          else{
              node=node.right; i++;}  
      }
    return i;
  } //end-Depth

  /*******************************************************
   * Performs an inorder traversal of the tree and prints [key, count] 
   * pairs in sorted order
   *******************************************************/
  public void Print(){ 
	  InorderTraversal(root);
  } //end-Print
   public void InorderTraversal(BSTNode root){
	    if (root == null) return;
	    InorderTraversal(root.left);
	    System.out.println("["+root.key+", "+root.count+"]");
	    InorderTraversal(root.right);
  }
}