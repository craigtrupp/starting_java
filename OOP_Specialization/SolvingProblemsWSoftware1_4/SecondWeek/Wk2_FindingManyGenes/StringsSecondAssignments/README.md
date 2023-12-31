## While Loop and Quick Exercises for IndexOf Checks
* This was a bit repetitive but found some value in the second part of the programming assignment. Quick section summaries below

--- 

#### **`Part 1: Finding many Genes`** 
This assignment is to write the code from the lesson to make the following improvements to your algorithm:

A. Find a gene in a strand of DNA where the stop codon could be any of the three stop codons “TAA”, “TAG”, or “TGA”.

B. Find all the genes (where the stop codon could be any of the three stop codons) in a strand of DNA.

This will help you see if you really understood how to put the code together, and might identify a part that you did not fully understand. If you get stuck, then you can go back and watch the coding videos that go with this lesson again.

Specifically, you should do the following:

1. Create a new Java project named StringsSecondAssignments. You can put all the classes for this programming exercise in this project.

2. Create a new Java Class named Part1. The following methods go in this class.

3. Write the method `findStopCodo`n that has three parameters, a String parameter named dna, an integer parameter named startIndex that represents where the first occurrence of ATG occurs in dna, and a String parameter named stopCodon. This method returns the index of the first occurrence of stopCodon that appears past startIndex and is a multiple of 3 away from startIndex. If there is no such stopCodon, this method returns the length of the dna strand.

4. Write the void method `testFindStopCodon` that calls the method findStopCodon with several examples and prints out the results to check if findStopCodon is working correctly. Think about what types of examples you should check. For example, you may want to check some strings of DNA that have genes and some that do not. What other examples should you check?

5. Write the method `findGene` that has one String parameter dna, representing a string of DNA. In this method you should do the following:
    * Find the index of the first occurrence of the start codon “ATG”. If there is no “ATG”, return the empty string.
    * Find the index of the first occurrence of the stop codon “TAA” after the first occurrence of “ATG” that is a multiple of three away from the “ATG”. Hint: call findStopCodon.
    * Find the index of the first occurrence of the stop codon “TAG” after the first occurrence of “ATG” that is a multiple of three away from the “ATG”. Find the index of the first occurrence of the stop codon “TGA” after the first occurrence of “ATG” that is a multiple of three away from the “ATG”. 
    * Return the gene formed from the “ATG” and the closest stop codon that is a multiple of three away. If there is no valid stop codon and therefore no gene, return the empty string.

#### **`Part 2: HowMany - Finding Multiple Occurrences`**
This assignment will write a method to determine how many occurrences of a string appear in another string.

Specifically, you should do the following:

1. Create a new Java Class named Part2in the StringsSecondAssignments project.

2. Write the method named `howMany` that has two String parameters named stringa and stringb. 
    - This method returns an integer indicating how many times stringa appears in stringb, where each occurrence of stringa must not overlap with another occurrence of it. 
    - For example, the call howMany(“GAA”, “ATGAACGAATTGAATC”) returns 3 as GAA occurs 3 times. The call howMany(“AA”, “ATAAAA”) returns 2. Note that the AA’s found cannot overlap.

3. Write the void method `testHowMany` has no parameters. 
    - Add code in here to call howMany with several examples and print the results. 
    - Think carefully about what types of examples would be good to test to make sure your method works correctly.