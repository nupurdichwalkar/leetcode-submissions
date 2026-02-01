class Solution:
    def numUniqueEmails(self, emails: List[str]) -> int:
        dict_email = defaultdict(set)

        def do_format(email_id: str) -> str:
            email_id = email_id.partition('+')[0].replace('.','')
            return email_id

        for email in emails:
            email_id , domain_name = email.split('@')
            actual_id = do_format(email_id)
            dict_email[domain_name].add(actual_id)
        ans = 0
        for email_ids in dict_email.values():
            ans += len(email_ids)
        return ans
