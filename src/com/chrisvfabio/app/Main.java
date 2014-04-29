/*
 * Copyright (c) 2014 Chris Fabio
 *
 *     Licensed under the Apache License, Version 2.0 (the "License");
 *     you may not use this file except in compliance with the License.
 *     You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *     Unless required by applicable law or agreed to in writing, software
 *     distributed under the License is distributed on an "AS IS" BASIS,
 *     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *     See the License for the specific language governing permissions and
 *     limitations under the License.
 */

package com.chrisvfabio.app;

import java.util.Random;

public class Main {

    public static final int MAX_STUDENTS = 20;
    private int numElems;
    private Student[] students;

    public Main() {
        students = new Student[MAX_STUDENTS];
        numElems = 0;
    }

    public static void main(String[] args) {
        Main m = new Main();
        m.insertStudents();
        m.displayStudents();
        m.insertionSort();
        m.displayStudents();
    }

    public void insertStudents() {
        for (int i = 0; i < 10; i++) {

            String firstName = "First name";
            String lastName = "Last name";
            double grade = Math.abs((new Random().nextDouble() * 100));

            students[i] = new Student(firstName, lastName, grade);

            numElems++;
        }
    }

    public void displayStudents() {
        System.err.println("Displaying students~");
        for (int i = 0; i < numElems; i++) {
            System.out.println(String.format("[%d] %.2f", i, students[i].getGrade()));
            // System.out.println(String.format("Student[%d]\nFirst name: %s\nLast name: %s\nGrade: %.2f", i, students[i].getFirstName(), students[i].getLastName(), students[i].getGrade()));
        }
    }

    public void insertionSort() {
        int in, out;

        for (out = 1; out < numElems; out++) {
            Student temp = students[out];
            in = out;

            while (in > 0 && students[in - 1].getGrade() >= temp.getGrade()) {
                students[in] = students[in - 1];
                --in;
            }

            students[in] = temp;
        }
    }
}
