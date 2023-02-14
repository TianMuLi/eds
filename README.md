# eds

【\\p{IsLatin}+(?:-\\p{IsLatin}+)*|\\d+】
[^\\p{L}+(\\-\\p{L}+)*\\d]+

\p{InBasic_Latin}

^(?:(?![<>%=])[\p{Latin}\s\d\p{P}\p{S}])*$

/[A-Za-z\\u0080-\\uFFFF -]{2,}/

@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR,
    ElementType.PARAMETER, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(List.class)
@Documented
@Constraint(validatedBy = {})
public @interface ErpValidate {

    int min() default 0;

    int max() default Integer.MAX_VALUE;

    boolean required() default false;

    String msg() default "参数不合规";

    String regex() default "";

    @Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR,
        ElementType.PARAMETER, ElementType.TYPE_USE})
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    @interface List {
        ErpValidate[] value();
    }
}
