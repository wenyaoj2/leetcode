class ConvertToTitle {
    public String convertToTitle(int n) {
        String result = "";
        while(n != 0) {
            int num = (n - 1) % 26;
            result = (char)('A' + num) + result;
            n = (n - 1) / 26;
        }
        return result;
    }
}