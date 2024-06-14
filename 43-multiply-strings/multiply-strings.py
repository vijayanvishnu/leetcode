class Solution:
    # @param num1, a string
    # @param num2, a string
    # @return a string
    def multiply(self, num1, num2):
        len_num1, len_num2 = len(num1), len(num2)
        if len_num2 < len_num1:
            return self.multiply(num2, num1)
        product = '0'
        for i, digit in enumerate(num1):
            tmp = '0' * (len_num1-i-1)
            tmp += self.multiply_helper(num2, digit)
            product = self.add_helper(product, tmp)
        return product[::-1]


    def digit_multiply(self, d1, d2):
        product = d1 * d2
        carrier = product // 10
        product -= carrier * 10
        return carrier, product

    def digit_add(self, d1, d2, c):
        sum = d1 + d2 + c
        carrier = 0
        if sum > 9:
            carrier = 1
            sum -= 10
        return carrier, sum

    def multiply_helper(self, str1, d):
        if d == '0':
            return '0'
        elif d == '1':
            return str1[::-1]
        carrier, res = 0, ''
        for i in range(len(str1)-1, -1, -1):
            carrier1, product = self.digit_multiply(int(str1[i]), int(d))
            carrier2, sum = self.digit_add(product, 0, carrier)
            _, carrier = self.digit_add(carrier1, carrier2, 0)
            res += str(sum)
        if carrier > 0:
            res += str(carrier)
        return res

    def add_helper(self, str1, str2):
        len_s1, len_s2 = len(str1), len(str2)
        if len_s1 > len_s2:
            return self.add_helper(str2, str1)
        res, carrier = '', 0
        for i in range(len_s1):
            carrier, sum = self.digit_add(int(str1[i]), int(str2[i]), carrier)
            res += str(sum)
        for i in range(len_s1, len_s2):
            carrier, sum = self.digit_add(int(str2[i]), 0, carrier)
            res += str(sum)
        if carrier > 0:
            res += str(carrier)
        return res