
/**
 * Created by pierre
 * Date: 16/04/2014 14:16
 * Replace domain extensions by "xxx" to avoid unwanted outgoing emails using customer database dumps.
 */
def cli = new CliBuilder(usage:'groovy anonymize -input input.sql -output output.sql')
cli.input(args:1, argName:'input', 'input file to be anonymized')
cli.output(args:2, argName:'output', 'output file with the content anonymized')
def options = cli.parse(args)

println "Input  : $options.input"
println "Output : $options.output"

File input = new File(options.input)
File output = new File(options.output)
BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(output)))
BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(input)))
try {
    String line = null
    int counter=0
    while ((line = reader.readLine()) != null) {
        String result = line.replaceAll("(@([A-Za-z0-9_\\-])+\\.[A-Za-z]([A-Za-z])+)", "@z" + counter++ +".xxx")
        writer.writeLine(result)
    }
} finally {
    writer.close()
    reader.close()
}

println "Done."
