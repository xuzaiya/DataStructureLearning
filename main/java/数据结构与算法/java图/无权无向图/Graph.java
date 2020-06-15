package 数据结构与算法.java图.无权无向图;

import sun.security.provider.certpath.Vertex;

public class Graph {
    private final int MAX_VERTS = 20; //表示定点的个数
    private Vertex vertexList[]; // 用来存储顶点的数组
    private int adjMat[][]; //用邻接矩阵来存储 边， 数组元素0表示无边，1表示有边
    private int nVerts; //顶点个数
    private StackX theStack ; // 用栈实现深度优先搜索
    private Queue queue ; //用队列实现广度优先搜索

    /*
    顶点类
     */
    class Vertex{
        public char label;
        public boolean wasVisited;

        public Vertex(char label){
            this.label = label;
            wasVisited = false;
        }
    }

    public Graph(){
        vertexList = new Vertex[MAX_VERTS];
        adjMat = new int[MAX_VERTS][MAX_VERTS];
        nVerts = 0; // 初始化顶点的个数为0
        //初始化邻接矩阵所有元素都为0，及所有顶点没有边
        for(int i=0;i<MAX_VERTS;i++){
            for (int j=0;j<MAX_VERTS;j++){
                adjMat[i][j] = 0;
            }
        }
        theStack = new StackX();
        queue = new Queue();
    }

    //将顶点添加到数组中，是否访问标志置为wasVisite=false 未访问
    public void addVertex(char lab){
        vertexList[nVerts++] = new Vertex(lab);
    }

    //注意用邻接矩阵表示边，是对称的，两边都要赋值
    public void addEdge(int start ,int end){
        adjMat[start][end] = 1;
        adjMat[end][start] = 1;

    }

    //打印某个顶点的表示值
    public void displayVertex(int v){
        System.out.print(vertexList[v].label);
    }

    /*
    深度优先搜索
        1.用peek（）方法检查栈顶的顶点
        2.用getAdjUnvisitedVertex()方法找到当前栈顶点邻接未被访问的顶点
        3.用第二步方法返回值不等于-1，则找到下一个未访问的邻接顶点，访问这个顶点，并入栈
        如果第二步方法范围值等于-1，则没有找到，出栈
     */
    public void depthFirstSearch(){
        //从第一个顶点开始访问
        vertexList[0].wasVisited = true; //访问之后标记为true
        displayVertex(0); //打印访问的第一个顶点
        theStack.push(0); //将第一个顶点放入栈中

        while(!theStack.isEmpty()){
            //找到当前顶点邻接未被访问的顶点
            int v= getAdUnvisitedVertex(theStack.peek());
            if (v== -1){
                // 如果顶点顶点的值-1，则表示没有相邻且未被访问的顶点，那么出栈
                theStack.pop();
            }else{
                //否则访问下一个邻接顶点
                vertexList[v].wasVisited = true;
                displayVertex(v);
                theStack.push(v);
            }
        }

        //栈访问完毕，重置所有标记为wasVisited = false;
        for (int i=0;i<nVerts;i++){
            vertexList[i].wasVisited = false;
        }

    }

    //找到与某一顶点邻接并且未被访问的顶点
    public int getAdUnvisitedVertex(int v){
        for (int i=0;i<nVerts;i++){
            //v顶点与i顶点相邻（邻接矩阵值为1）且未被访问wasVisited == false;
            if (adjMat[v][i] == 1 && vertexList[i].wasVisited == false){
                return i;
            }
        }
        return -1;
    }


    /*
    广度优先搜索
    1.用remove方法检查栈顶的顶点
    2.试图找到这个顶点还未被访问的邻接顶点
    3.如果没有找到，该顶点出列
    4.如果找到这样的顶点，访问这个顶点，并入列
     */
    public void breadFirstSearch(){
        vertexList[0].wasVisited = true;
        displayVertex(0);
        queue.insert(0);
        int v2;
        while(!queue.isEmpty()){
            int v1 = queue.remove();
            while((v2 =getAdUnvisitedVertex(v1))!=-1){
                vertexList[v2].wasVisited = true;
                displayVertex(v2);
                queue.insert(v2);
            }
        }

        //搜索完毕，初始化，以便下次搜索
        for (int i=0;i<nVerts;i++){
            vertexList[i].wasVisited = false;
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addVertex('A');
        graph.addVertex('B');
        graph.addVertex('C');
        graph.addVertex('D');
        graph.addVertex('E');

        graph.addEdge(0,1);//AB
        graph.addEdge(1,2);//BC
        graph.addEdge(0,3);//AD
        graph.addEdge(3,4);//DE

        System.out.println("深度优先搜索算法：");
        graph.depthFirstSearch();
    }

}
