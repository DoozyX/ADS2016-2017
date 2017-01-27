package labs.lab7.p1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

/**
 Windows Explorer Problem 1
 You should implement Windows Explorer by using a tree. Nodes are directories/files. Initially you have only one directory c: and it is your current directory. You will be given an array of commands where each command is one of the following:

 CREATE [name of directory/file] - you should create new directory/file in the current directory. Be careful when adding new directory/file, it should be put in a position such that all directories/files in the current folder will be sorted lexicographically.

 OPEN [name of directory/file] - you open the directory in the current folder and the current folder is changed.

 DELETE [name of directory/file] - you delete the folder/file.

 BACK - you are back in the previous directory.

 PATH - prints the path of the current directory, for example c: \ users \ darko \ mydocuments.

 PRINT - prints the whole file system structure such that each directory/file is printed in a new line with spaces equal to level of that directory/file.

 Note: The names of the directories/files contain only one word composed of lowercase Latin letters.

 Sample input
 15
 CREATE a
 OPEN a
 CREATE b
 CREATE d
 CREATE c
 PATH
 OPEN c
 PATH
 CREATE u
 CREATE g
 CREATE h
 PATH
 BACK
 PATH
 PRINT

 Sample output
 c:\a\
 c:\a\c\
 c:\a\c\
 c:\a\
 c:
 a
 b
 c
 g
 h
 u
 d
 */

public class WindowsExplorer {

    public static void main(String[] args) throws Exception {
        int i;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String commands[] = new String[N];

        for (i=0;i<N;i++)
            commands[i] = br.readLine();

        br.close();

        SLLTree<String> tree = new SLLTree<>();
        tree.makeRoot("c:");

        // vasiot kod stoi ovde
        SLLNode<String> current = (SLLNode<String>)tree.root();
        for (String lines : commands) {
            String[] line = lines.split("\\s+");
            String command = line[0];
            switch (command) {
                case "CREATE":
                    create(line[1], tree, current);
                    break;
                case "OPEN":
                    current = open(line[1], current);
                    break;
                case "DELETE":
                    delete(line[1], tree, current);
                    break;
                case "BACK":
                    current = back(current);
                    break;
                case "PATH":
                    path(tree, current);
                    break;
                case "PRINT":
                    print(tree);
                    break;
            }
        }

    }

    static void create(String name, SLLTree<String> tree, SLLNode<String> current) {
        SLLNode<String> temp = current.firstChild;
        SLLNode<String> position = null;
        while (temp != null){
            if (temp.getElement().compareTo(name) < 0) {
                position = temp;
                temp = temp.sibling;
            } else {
                break;
            }
        }

        if (position == null){
            tree.addChild(current, name);
        } else {
            @SuppressWarnings("unchecked")
            SLLNode<String> node = new SLLNode(name);
            node.parent = current;
            node.sibling = position.sibling;
            position.sibling = node;
        }
    }
    static SLLNode<String> open(String name, SLLNode<String> current) {
        SLLNode<String> temp = current.firstChild;
        while (temp != null){
            if (temp.getElement().equals(name)) {
                current = temp;
                break;
            }
            temp = temp.sibling;
        }
        return current;
    }
    static void delete(String name, SLLTree<String> tree, SLLNode<String> current) {
        SLLNode<String> temp = current.firstChild;
        while(!temp.getElement().equals(name)){
            temp=temp.sibling;
        }
        tree.remove(temp);
    }
    static SLLNode<String> back(SLLNode<String> current) {
        return current.parent;

    }
    static void path(SLLTree<String> tree, SLLNode<String> current) {
        SLLNode<String> temp = current;
        StringBuilder sb = new StringBuilder("c:\\");
        ArrayDeque<String> arrayDeque = new ArrayDeque<>();
        while(temp!=tree.root) {
            arrayDeque.push(temp.getElement());
            temp=temp.parent;
        }
        while (arrayDeque.peek() != null) {
            sb.append(arrayDeque.pop()).append('\\');
        }
        System.out.println(sb.toString());
    }
    static void print(SLLTree<String> tree) {
        tree.printTree();
    }


}
