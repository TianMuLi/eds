# eds

【\\p{IsLatin}+(?:-\\p{IsLatin}+)*|\\d+】
[^\\p{L}+(\\-\\p{L}+)*\\d]+

\p{InBasic_Latin}

^(?:(?![<>%=])[\p{Latin}\s\d\p{P}\p{S}])*$

/[A-Za-z\\u0080-\\uFFFF -]{2,}/

public class JudgeParamConstraintValidator implements ConstraintValidator<JudgeParam, String> {
    List<?> list;
 
    /**
     * @description: 初始化时候 执行
     * @param: [constraintAnnotation]
     * @return: void
     **/
    @Override
    public void initialize(JudgeParam constraintAnnotation) {
        //拿到了 我们在代码中指定的 0,1, 如果代码指定4,5,6拿到就是456,代码中指定的啥拿到是啥
        String[] judge = constraintAnnotation.judge();
        list = CollectionUtils.arrayToList(judge);
    }
 
    /**
     * @description: 校验
     * @param: [value, constraintValidatorContext]
     * @return: boolean
     **/
    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        //value 表示前端传过来的数据 返回值 是boolean
        return list.contains(value);
    }
 
 
}
