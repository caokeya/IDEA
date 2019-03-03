package com.Java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

/*
给定一个列表 accounts，每个元素 accounts[i] 是一个字符串列表，其中第一个元素 accounts[i][0] 是 名称 (name)，其余元素是 emails 表示该帐户的邮箱地址。
现在，我们想合并这些帐户。如果两个帐户都有一些共同的邮件地址，则两个帐户必定属于同一个人。
请注意，即使两个帐户具有相同的名称，它们也可能属于不同的人，因为人们可能具有相同的名称。一个人最初可以拥有任意数量的帐户，但其所有帐户都具有相同的名称。
合并帐户后，按以下格式返回帐户：每个帐户的第一个元素是名称，其余元素是按顺序排列的邮箱地址。accounts 本身可以以任意顺序返回。
例子 1:
Input: 
accounts = [["John", "johnsmith@mail.com", "john00@mail.com"],
            ["John", "johnnybravo@mail.com"], 
            ["John", "johnsmith@mail.com", "john_newyork@mail.com"], 
            ["Mary", "mary@mail.com"]]
Output: [["John", 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com'], 
         ["John", "johnnybravo@mail.com"], 
         ["Mary", "mary@mail.com"]]
Explanation: 
  第一个和第三个 John 是同一个人，因为他们有共同的电子邮件 "johnsmith@mail.com"。 
  第二个 John 和 Mary 是不同的人，因为他们的电子邮件地址没有被其他帐户使用。
  我们可以以任何顺序返回这些列表，例如答案[['Mary'，'mary@mail.com']，['John'，'johnnybravo@mail.com']，
  ['John'，'john00@mail.com'，'john_newyork@mail.com'，'johnsmith@mail.com']]仍然会被接受。
 */
public class _721_Accounts_Merge_账户合并 {
    class Solution {
        /*
         * 并查集的几个重要概念，1.大类。2. 类的合并。 3. 类的代表。 
         * 其中类的合并是online进行的。
         * 这道题中，对于每一个email string,他们的基础关系就是在同一个初始account里面的那些string。
         * 仅此而已，而如果在两个account里面出现了同一个email,则可以通过online 合并的方式，把这两个acount所对应的大类并在一起。
         * 这道题里面，对于每一个string pair而言，其实有两种连接方式，第一种就是在同一个account 里面，第二种就是作为同一个string,
         * 他们出现在不同的account里面，进而把这两个accounts里面所有其他的string也都一块连接到了一起，成了一个大类。
         * 并查集里面，一定要有父亲和祖宗概念的区分。parents里面记录的是元素何其直系父亲的关系，而祖宗必须用find函数来查找
         */
        public List<List<String>> accountsMerge(List<List<String>> acts) {
            List<List<String>> result = new ArrayList<>();
            if (acts == null || acts.size() == 0){
                return result;
            }
            Map<String, String> parents = new HashMap<String, String>();//parents记录的每一个元素和他的只系父亲的关系，而非祖宗
            Map<String, String> owners = new HashMap<String, String>();
            Map<String, TreeSet<String>> unions = new HashMap<String, TreeSet<String>>();//因为最后有一个排序要求，所以我们加的时候要用treeset
            for (List<String> a : acts){//并查集，第一步永远都是让每一个元素都先自成一类
                for (int i = 1; i < a.size(); i++){
                    parents.put(a.get(i), a.get(i));
                    owners.put(a.get(i), a.get(0));
                }
            }
            for (List<String> a : acts){//第二步最关键，就是并查集当中，并的过程,online来并,根据上面的描述，
                                        //并的时候，我们只需要以同一个account里面的email为根据来并就足够了。
                if (a.size() == 1){//只有名字的account，因为没有任何email,所以我们只能当他们是自成一类，直接加到result里
                    List<String> cur = new ArrayList<>();
                    cur.add(a.get(0));
                    result.add(cur);
                    continue;
                }
                String p = find(a.get(1), parents);//一个account里面，第一个string的祖宗就是大家的祖宗的祖宗
                for (int i = 2; i < a.size(); i++){
                    parents.put(find(a.get(i), parents), p);
                }
            }
            
            for (String s : parents.keySet()){//开始合并，记住我们找的是祖宗，而不是父亲。父亲是map.get(s)可以得到，并的时候，必须用find找祖宗才行
                String p = find(s, parents);
                if (!unions.containsKey(p)){
                    TreeSet<String> set = new TreeSet<String>();
                    unions.put(p, set);
                }
                unions.get(p).add(s);
            }
            
            for (String s : unions.keySet()){
                List<String> cur = new ArrayList<>();
                TreeSet<String> set = unions.get(s);
                String name = owners.get(s);
                cur.add(name);
                while (!set.isEmpty()){
                    cur.add(set.pollFirst());
                }
                result.add(cur);
            }
            return result;
        }
        
        private String find(String p, Map<String, String> parents){//物理定义，返回p的祖宗，同时把p以及所有p到他祖宗路径上的所有元素都把他们的直接父亲变成祖宗。
            if (p.equals(parents.get(p))){
                return p;
            }
            String temp = find(parents.get(p), parents);
            parents.put(p, temp);
            return temp;
        }
    }
    
    class Solution2 {
        public List<List<String>> accountsMerge(List<List<String>> accounts) {
            Map<String, String> owner = new HashMap<>(), parents = new HashMap<>();
            for (List<String> account: accounts) {
                String user = account.get(0);
                for (int i = 1; i < account.size(); i++) {
                    owner.put(account.get(i), user);
                    parents.putIfAbsent(account.get(i), account.get(i));
                }
                
                for (int i = 2; i < account.size(); i++) {
                    String A = find(parents, account.get(1));
                    String B = find(parents, account.get(i));
                    parents.put(B, A);
                }
            }
            
            Map<String, List<String>> map = new HashMap<>();
            for (String mail: owner.keySet()) {
                String p = find(parents, mail);
                map.putIfAbsent(p, new ArrayList<>());
                map.get(p).add(mail);
            }
            List<List<String>> res = new ArrayList<>();
            for (String key: map.keySet()) {
                List<String> tmp = new ArrayList<>();
                tmp.addAll(map.get(key));
                Collections.sort(tmp);
                tmp.add(0, owner.get(key));
                res.add(tmp);
            }
            return res;
        }
        
        private String find(Map<String, String> parents, String s) {
            if (parents.get(s).equals(s)) return s;
            String p = find(parents, parents.get(s));
            parents.put(s, p);
            return p;
        }
    }
}
