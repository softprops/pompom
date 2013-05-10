package pom

object Pom {
  case class Project(modelVersion: Int,
                     groupId: String,
                     artifactId: String,
                     version: String,
                     packaging: String = "pom",
                     modules: Iterable[Module] = Nil,
                     parent: Option[Parent],
                     properties: Map[String, String] = Map.empty[String, String],
                     dependencies: Iterable[Dependency],
                     repositories: Iterable[Repository],
                     pluginRepositories: Iterable[PluginRepository],
                     build: Build,
                     reporting: Reporting)

  case class Repository(id: String,
                        name: String,
                        layout: String,
                        url: String,
                        snapshots: Boolean)

  case class PluginRepository(id: String,
                             name: String,
                             url: String,
                             layout: String,
                             snapshots: Boolean,
                             releases: Releases)
  
  case class Releases(updatePolicy: String)

  case class Build(directory: String,
                   outputDirectory: String,
                   finalName: String,
                   testOutputDirectory: String,
                   sourceDirectory: String,
                   scriptSourceDirectory: String,
                   testSourceDirectory: String,
                   resources: Iterable[Resource],
                   testResources: Iterable[Resource])

  case class Reporting(outputDirectory: String)

  case class Resource(directory: String)

  case class Dependency(groupId: String, 
                        artifactId: String,
                        version: String)

  case class Parent(groupId: String,
                    artifactId: String,
                    version: String,
                    relativePath: String)

  case class Module(path: String)
}
