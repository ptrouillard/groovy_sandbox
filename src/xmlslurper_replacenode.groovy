import groovy.xml.XmlUtil
import groovy.xml.StreamingMarkupBuilder
import groovy.util.slurpersupport.Node

def var = '''
 <rules>
   <validations>
      <max>test</max>
      <min>testencode</min>
      <child><max>remain the same</max></child>
   </validations>
 </rules>
'''

def nodes = new XmlSlurper().parseText(var)
def mynodes = nodes.validations.'*'.'*'.find {
it.name() == "max"}

println mynodes
 
mynodes.each { n->
  n.replaceNode {}
  println "ok: " + n.getClass().toString()
}

println XmlUtil.serialize(new StreamingMarkupBuilder().bind {
 mkp.yield nodes
})

