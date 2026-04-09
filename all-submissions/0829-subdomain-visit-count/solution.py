from collections import defaultdict
class Solution:
    def subdomainVisits(self, cpdomains: List[str]) -> List[str]:
        domainCountMap = defaultdict(int)
        for i in range(len(cpdomains)):
            count, domainName = cpdomains[i].split()
            subdomains = domainName.split(".")
            for i in range(len(subdomains)):
                d = ".".join(subdomains[i:])
                domainCountMap[d] += int(count)
        
        result = []
        for domain, count in domainCountMap.items():
            result.append(str(count) + " " + domain)
            
        return result
            
        
