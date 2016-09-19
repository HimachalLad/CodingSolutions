



package MyPractice;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.TreeMap;
import java.util.TreeSet;
 
public class Cf701C {
 
        
        public static void main(String args[]) throws IOException{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(br.readLine());
            String s = br.readLine();
                TreeSet<Character> s1 = new TreeSet<>();
                for(int i = 0; i < n; i++){
                    s1.add(s.charAt(i));
                }
                StringBuffer st = new StringBuffer();
                for(char c : s1){
                    st.append(c);
                }
                String c = st.toString();
                System.out.println(solve(s,c));
        }
        public static int solve(String s, String c){
            int sl = s.length();
            int cl = c.length();
            int needToFind[] = new int[256];
            
            // needToFind Initialization
            for(int i = 0; i < cl; i++) needToFind[c.charAt(i)]++;
            
            int hasFound[] = new int[256];
            int count = 0;
            //Ultimate aim is to get window of minimum length
            int minWindow = 0, maxWindow = 0, minWinLength = Integer.MAX_VALUE;
            
            
            for(int end = 0, begin = 0; end < sl; end++){
                
                if(needToFind[s.charAt(end)] == 0) continue;
            
                hasFound[s.charAt(end)]++;
                
                if(hasFound[s.charAt(end)] <= needToFind[s.charAt(end)])
                    count++;
                
              if(count == cl){
               while(needToFind[s.charAt(begin)] == 0 || (hasFound[s.charAt(begin)] > needToFind[s.charAt(begin)])){
                     
                        if(hasFound[s.charAt(begin)] > needToFind[s.charAt(begin)]) 
                        hasFound[s.charAt(begin)]--;
                        
                        begin++;   
                    }
                    int winLength = end - begin + 1;
                    if(winLength < minWinLength){
                        minWinLength = winLength;
                    }
                }
            }
            
            
            return minWinLength;
        }
}
 