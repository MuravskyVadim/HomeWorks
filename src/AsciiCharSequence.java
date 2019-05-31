public class AsciiCharSequence implements java.lang.CharSequence {
    private byte[] byteArray;

    public AsciiCharSequence(byte[] byteArray) {
        this.byteArray = byteArray;
    }

    @Override
    public int length() {
        return byteArray.length;
    }

    @Override
    public char charAt(int index) {
        return (char) byteArray[index];
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        byte[] tempArray;
        if(end > start){
            tempArray = new byte[end - start];
        }else {
            tempArray = new byte[0];
        }

        for (int i = 0; start < end; i++, start++) {
            tempArray[i] = byteArray[start];
        }

        return new AsciiCharSequence(tempArray);
    }

    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < byteArray.length; i++) {
            stringBuilder.append((char) byteArray[i]);
        }
        return stringBuilder.toString();
    }
}
