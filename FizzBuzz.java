class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> ls = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            if(i%3 == 0 && i%5 == 0) ls.add("FizzBuzz");
            else if(i%3 == 0) ls.add("Fizz");
            else if(i%5 == 0) ls.add("Buzz");
            else ls.add(i + "");
        }
        return ls;
    }
}
