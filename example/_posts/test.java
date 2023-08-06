import java.util.*;
import java.io.*;


public class Main
{
    private static int[][] map;
    private static boolean[][] visited;
    private static int result;
    private static int[] dx = {1,-1,0,0};
    private static int[] dy= {0,0,1,-1};
    private static int N;
    private static int totalCnt;
    private static List<Integer> blockCnt = new ArrayList();
    
    public static void main(String args[])
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map =new int[N][N];
        visited = new boolean[N][N];
        totalCnt = 0;

        for(int i= 0; i < N; i++){
            String input = br.readLine();
            for(int j = 0; j < N; j++){
                map[i][j] = input.charAt(j)-'0';
            }
        }
        for(int i= 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(visited[i][j]) continue;
                if(map[i][j] == 0) continue;
                totalCnt++;
                bfs(r,c);
            }
        }

        System.out.println(totalCnt);
        Collections.sort(blockCnt);
        for(int i = 0; i < totalCnt; i++){
            System.out.println(blockCnt.get(i));
        }

    }

    public static void bfs(int r, int c){
        Queue<int[]> queue = new ArrayDeque<>();

        int cnt = 1;
        queue.add(new int[]{r,c});
        visited[r][c] = true;

        while(queue.isEmpty()){
            int[] temp = queue.poll();
            int x = temp[0];
            int y = temp[1];

            for(int i = 0; i < 4; i++){
                int nx = x +dx[i];
                int ny = y +dy[i];

                if(isOverRange(nx,ny)) continue;
                if(visited[nx][ny]) continue;
                if(map[nx][ny] == 0) continue;

                visited[nx][ny] = true;
                queue.add(new int[]{nx,ny});
                cnt++;
            }
        }
        blockCnt.add(cnt);
    }
    public static boolean isOverRange(int x, int y){
        return x < 0 || x >= N|| y < 0 || y >= N;
    }
}