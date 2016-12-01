package dec;

/**
 * @author li_zhf
 * @Description: TODO
 * @date 2016/11/2 18:52
 */
public class Dec {

    final static int i = 10;
    public static void main(String[] args) {
        String data = "cafe babe 0000 0034 0029 0a00 0900 120a\n" +
                "0013 0014 0900 1500 160a 0017 0018 0a00\n" +
                "1700 1908 001a 0a00 1700 1b07 001c 0700\n" +
                "1d01 0006 3c69 6e69 743e 0100 0328 2956\n" +
                "0100 0443 6f64 6501 000f 4c69 6e65 4e75\n" +
                "6d62 6572 5461 626c 6501 0004 6d61 696e\n" +
                "0100 1628 5b4c 6a61 7661 2f6c 616e 672f\n" +
                "5374 7269 6e67 3b29 5601 000a 536f 7572\n" +
                "6365 4669 6c65 0100 0b4d 7954 6573 742e\n" +
                "6a61 7661 0c00 0a00 0b07 001e 0c00 1f00\n" +
                "2007 0021 0c00 2200 2307 0024 0c00 2500\n" +
                "260c 0025 0027 0100 0474 6573 740c 0025\n" +
                "0028 0100 064d 7954 6573 7401 0010 6a61\n" +
                "7661 2f6c 616e 672f 4f62 6a65 6374 0100\n" +
                "116a 6176 612f 6c61 6e67 2f49 6e74 6567\n" +
                "6572 0100 0776 616c 7565 4f66 0100 1628\n" +
                "4929 4c6a 6176 612f 6c61 6e67 2f49 6e74\n" +
                "6567 6572 3b01 0010 6a61 7661 2f6c 616e\n" +
                "672f 5379 7374 656d 0100 036f 7574 0100\n" +
                "154c 6a61 7661 2f69 6f2f 5072 696e 7453\n" +
                "7472 6561 6d3b 0100 136a 6176 612f 696f\n" +
                "2f50 7269 6e74 5374 7265 616d 0100 0770\n" +
                "7269 6e74 6c6e 0100 0428 4929 5601 0015\n" +
                "284c 6a61 7661 2f6c 616e 672f 4f62 6a65\n" +
                "6374 3b29 5601 0015 284c 6a61 7661 2f6c\n" +
                "616e 672f 5374 7269 6e67 3b29 5600 2100\n" +
                "0800 0900 0000 0000 0200 0100 0a00 0b00\n" +
                "0100 0c00 0000 1d00 0100 0100 0000 052a\n" +
                "b700 01b1 0000 0001 000d 0000 0006 0001\n" +
                "0000 0001 0009 000e 000f 0001 000c 0000\n" +
                "005a 0002 0004 0000 002a 1100 81b8 0002\n" +
                "4d07 b800 024e b200 0305 b600 04b2 0003\n" +
                "2cb6 0005 b200 032d b600 05b2 0003 1206\n" +
                "b600 07b1 0000 0001 000d 0000 001e 0007\n" +
                "0000 0004 0007 0005 000c 0006 0013 0007\n" +
                "001a 0008 0021 0009 0029 000a 0001 0010\n" +
                "0000 0002 0011  ";
        System.out.println(hexToChar(data));
    }

    public static String hexToChar(String data) {
        String dataNew = data.trim().replace("\n","").replace(" ","");
        String result = "";
        int length = dataNew.length();
        if (length == 0 || length % 2 != 0 ) {
            return null;
        }

        for (int i = 0 ; i < length ; i += 2 ) {
            String tmp = String.valueOf(dataNew.charAt(i)) + String.valueOf(dataNew.charAt(i+1));
            result += (char) Integer.parseInt(tmp,16);
        }
        return result;
    }
}
