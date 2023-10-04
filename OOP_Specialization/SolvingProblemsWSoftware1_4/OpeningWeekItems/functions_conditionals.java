// Quiz Items and Practice Writing Java Functions and Conditionals

int func2(int w){
    return w * 3;
}

int func1(int a, int b){
    int n = a + b;
    return 2 + func2(n);
}

int start(){
    int z = 4;
    return func1(z, 1) - 3;
}


// Question for above code snippet
// 1. - What is the return value of the call start()
    // Steps
    // func1 == func1(4, 1)
        // n = 4 + 1 == 5
        // return 2 + func2(5) 
            // func2 == 5 * 3 == 15
        // (Back to func1)
        // return 2 + 15 == 17
    // start func would no be 17 - 3 == 14 



// Next Snippet for Question 2 
int g (int a){
    if (a < 9){
        return 9;
    }
    if (a < 7){
        return 7;
    }
    if (a < 4) {
        return 4;
    }
    return 0;
}
// Question : What is the value returned from the call g(5) -- First if should execute then return 9 and exit the execution of the method/function g


// Next Snippet for Question 3
int k (int a, int b) {
    if (a < b) {
        if (b > 4) {
            return 0;
        }
        else {
            return 1;
        }
    }
    else {
        if (a > 4) {
            return 2;
        }
        else {
            return 3;
        }
    }
}

// Question : For which of the values a and b would 2 be the return value
// Button (Selections Option)
// 1. a=6, b=8
// 2. a=6, b=6
// 3. a=2, b=0
// 4. 1=1, b=3

// Only condition would be the second