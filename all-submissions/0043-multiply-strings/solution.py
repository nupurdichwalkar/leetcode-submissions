class Solution:
    def multiply(self, num1: str, num2: str) -> str:

        if num1 =="0" or num2 == "0":
            return "0"

        num1 = num1[::-1]
        num2 = num2[::-1]
        results = []
        

        def multiply_one_digit(digit, index, num1):
            curr_val = [0]* index
            carry = 0
            for d in num1:
                val = int(digit) * int(d) + carry
                curr_val.append(val%10)
                carry = val//10

            if carry != 0:
                curr_val.append(carry)
            return curr_val

        def sum_results(results):
            answer = results.pop()

            # Add each result to answer one at a time.
            for result in results:
                new_answer = []
                carry = 0

                # Sum each digit from answer and result. Note: zip_longest is the
                # same as zip, except that it pads the shorter list with fillvalue.
                for digit1, digit2 in zip_longest(result, answer, fillvalue=0):
                    # Add current digit from both numbers.
                    curr_sum = digit1 + digit2 + carry
                    # Set carry equal to the tens place digit of curr_sum.
                    carry = curr_sum // 10
                    # Append the ones place digit of curr_sum to the new answer.
                    new_answer.append(curr_sum % 10)

                if carry != 0:
                    new_answer.append(carry)

                # Update answer to new_answer which equals answer + result
                answer = new_answer
            return answer



        for index, digit in enumerate(num2):
            results.append(multiply_one_digit(digit, index, num1))
        answer = sum_results(results)
        return "".join(str(digit) for digit in reversed(answer))

        


