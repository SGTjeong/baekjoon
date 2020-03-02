import java.util.*;

public class programmers3 {
    static HashMap<String, Integer> map;
    public static void main(String []args){
        String []genres = {"classic", "pop", "classic", "classic", "pop"};
        int []plays ={500, 600, 150, 800, 2500};
        int arr[] = Solution.solution(genres, plays);
        for(int i =0 ; i<arr.length; i++) System.out.println(arr[i]);
    }

    static   class Solution {
        public static int[] solution(String[] genres, int[] plays) {
            HashMap<String, ArrayList<Integer>> hashMap = new HashMap<>();
            TreeMap<String, Integer> treeMap = new TreeMap<>();

            for(int i=0; i<genres.length; i++){
                if(hashMap.get(genres[i])==null){
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(i);
                    hashMap.put(genres[i], list);
                    treeMap.put(genres[i], plays[i]);
                }
                else{
                    ArrayList<Integer> list = hashMap.get(genres[i]);
                    list.add(i);
                    hashMap.put(genres[i], list);
                    treeMap.put(genres[i], treeMap.get(genres[i]) + plays[i]);
                }
            }

            LinkedList<Integer> ans = new LinkedList<>();

            ArrayList<String> s = new ArrayList<>();

            for(String genre: treeMap.keySet()){
                if(s.size() == 0) s.add(genre);
                else{
                    int i=0;
                    for(i=0; i<s.size(); i++){
                        if(treeMap.get(genre) > treeMap.get(s.get(i))){
                            s.add(i, genre);
                            break;
                        }
                    }
                    if(i==s.size()) s.add(genre);
                }
            }

            for(String genre : s){
                ArrayList<Integer> list = hashMap.get(genre);
                Collections.sort(list, new Comparator<Integer>(){
                    public int compare(Integer a, Integer b){
                        if(plays[a] < plays[b]) return 1;
                        else if(plays[a] > plays[b]) return -1;
                        else{
                            if(a < b) return -1;
                            else return 1;
                        }
                    }
                });

                if(list.size()==1){
                    ans.add(list.get(0));
                }
                else{
                    ans.add(list.get(0));
                    ans.add(list.get(1));
                }
            }

            int []answer = new int[ans.size()];
            for(int i = 0; i<ans.size(); i++){
                answer[i] = ans.get(i);
            }
            return answer;
        }
    }

}

