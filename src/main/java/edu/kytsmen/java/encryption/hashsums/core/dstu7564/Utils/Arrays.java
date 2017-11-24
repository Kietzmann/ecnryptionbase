package edu.kytsmen.java.encryption.hashsums.core.dstu7564.Utils;

public class Arrays {
    public static long[] clone(long[] data)
    {
        if (data == null)
        {
            return null;
        }
        long[] copy = new long[data.length];

        System.arraycopy(data, 0, copy, 0, data.length);

        return copy;
    }


    public static byte[] clone(byte[] data)
    {
        if (data == null)
        {
            return null;
        }
        byte[] copy = new byte[data.length];

        System.arraycopy(data, 0, copy, 0, data.length);

        return copy;
    }


    public static void fill(
            long[] array,
            long value)
    {
        for (int i = 0; i < array.length; i++)
        {
            array[i] = value;
        }
    }
}
