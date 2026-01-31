
# Reference; https://www.youtube.com/watch?v=q6IEA26hvXc
class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        A, B = nums1, nums2
        if len(B) < len(A):
            B, A = A,B
        total = len(A) + len(B)
        half = total // 2

        l = 0
        r = len(A)-1
        while True:
            mid = (l+r) //2
            remaining = half - mid - 2
            Aleft = A[mid] if mid >= 0 else float("-inf")
            Aright = A[mid+1] if mid +1 < len(A) else float("inf")
            Bleft = B[remaining] if remaining >= 0 else float("-inf")
            Bright = B[remaining+1]  if remaining+1 < len(B) else float("inf")
            if (Aleft <= Bright and Bleft <= Aright):
                #even
                if total % 2:
                    return min(Aright, Bright)
                return (max(Aleft, Bleft) + min(Aright, Bright)) /2
                
            else:
                if Aleft > Bright:
                    r = mid-1
                else:
                    l = mid+1
