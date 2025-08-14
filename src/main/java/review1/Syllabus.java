package review1;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 课程表
 * // TODO 入度为0 开始更新遍历
 */
public class Syllabus {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // degree数组记录每门课程的入度
        int[] degree = new int[numCourses];
        // graph是邻接表表示课程之间的依赖关系
        List<List<Integer>> graph = new ArrayList<>();
        // 初始化邻接表，每门课程对应一个空的依赖列表
        for(int i = 0; i < numCourses; i++){
            graph.add(new ArrayList<>());
        }
        // 将prerequisites数组中的先修关系转换成图和入度记录
        for(int[] edge : prerequisites){
            graph.get(edge[1]).add(edge[0]); // edge[1] -> edge[0]，即edge[0]的一个前置课程是edge[1]
            degree[edge[0]]++; // edge[0]课程入度加1，表示它还需要edge[1]先修
        }
        // 创建一个队列用于存放入度为0的课程
        Deque<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            if(degree[i] == 0){
                queue.add(i);
            }
        }
        // 记录已经可以学习的课程数量
        int courses = 0;
        // 拓扑排序开始：从入度为0的课程开始逐个处理
        while(!queue.isEmpty()){
            int u = queue.poll(); // 取出一个入度为0的课程
            courses++; // 已完成一门课程学习
            // 遍历它指向的后续课程，减少这些后续课程的入度
            for(int v : graph.get(u)){
                degree[v]--;
                // 如果入度变成0，表示该课程的所有先修课都已满足，可以入队继续学习
                if(degree[v] == 0){
                    queue.add(v);
                }
            }
        }
        // 如果最终学习课程数等于总课程数，说明无环，课程可以完成
        return courses == numCourses;
    }
}
