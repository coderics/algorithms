using System;

namespace QueenApplication
{
    public class Utils
    {
        enum Letter
        {
            a, b, c, d, e, f, g, h
        }

        public static String GetLetterName(int num)
        {
            foreach (Letter letter in Enum.GetValues(typeof(Letter)))
            {
                if ((int)letter == num)
                {
                    return letter.ToString();
                }
            }

            return null;
        }
    }

}
