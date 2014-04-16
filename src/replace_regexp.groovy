
/**
 * Created by pierre
 * Date: 16/04/2014 11:54
 */

// detect
def origin = "this is my email : ptrouillard@gmail.com, please do not send email with it !"
def modified = (origin =~ /.*@.*/).replaceAll("anonymous@email.com.xxx")
println "changed '$origin' to '$modified'"

// replace pattern
println origin.replaceAll("(\\.com)", ".com.xxx")


