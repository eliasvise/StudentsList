package org.example;

public class StudentFileList {
    Node head;

    public StudentFileList() {
        this.head = null;
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public class Node{
        Student student;
        Node next;

        Node(Student student){
            this.student = student;
            this.next = null;
        }

        public Student getStudent() {
            return student;
        }

        public void setStudent(Student student) {
            this.student = student;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{ Student= " + student + '}';
        }
    }

    public void addStudent(Student student) {
        Node newNode = new Node(student);
        newNode.next = this.head;
        head = newNode;
    }

    public boolean exists(int id) {
        Node current = head;
        while (current != null) {
            if (current.getStudent().getId() == id) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    public void modify(Student student) {
        if (exists(student.getId())) {
            Node current = head;
            while (current != null) {
                if (current.getStudent().getId() == student.getId()) {
                    current.setStudent(student);
                    return;
                }
                current = current.getNext();
            }
        } else {
            System.out.println("Student with ID " + student.getId() + " not exist.");
        }
    }

    public Student extract(int id) {
        if (exists(id)) {
            Node current = head;
            Node previous = null;
            while (current != null) {
                if (current.getStudent().getId() == id) {
                    if (previous == null) {
                        head = current.getNext();
                    } else {
                        previous.setNext(current.getNext());
                    }
                    return current.getStudent();
                }
                previous = current;
                current = current.getNext();
            }
        } else {
            System.out.println("Student with ID " + id + " not found.");
            return null;
        }
        return null;
    }

    public void delete(int id) {
        extract(id);
    }

    public void showStudentList() {
        Node current = head;
        while (current != null) {
            System.out.println(current.getStudent()); // Print the student using toString()
            current = current.getNext();
        }
        System.out.println("\nList showed.\n");
    }
}
