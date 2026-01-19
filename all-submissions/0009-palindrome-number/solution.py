class Solution:
    def isPalindrome(self, x: int) -> bool:
        if x < 0:
            return False
        s = str(x)
        my_list = [int(digit) for digit in s]
        my_new_list = my_list[::-1]
        if (my_list) == my_new_list:
            return True
        return False

