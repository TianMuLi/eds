# eds

【\\p{IsLatin}+(?:-\\p{IsLatin}+)*|\\d+】
[^\\p{L}+(\\-\\p{L}+)*\\d]+

\p{InBasic_Latin}

^(?:(?![<>%=])[\p{Latin}\s\d\p{P}\p{S}])*$

/[A-Za-z\\u0080-\\uFFFF -]{2,}/

<dependency><groupId>org.springframework.boot</groupId><artifactId>spring-boot-properties-migrator</artifactId><scope>runtime</scope>
</dependency>
