$version: "2"

namespace footballdata


use aws.protocols#restJson1
use footballdata#AreaResource
use footballdata#CompetitionResource

@restJson1
service FootballData {
    version: "1.0"
    resources: [AreaResource, CompetitionResource]
    operations: []
}

@timestampFormat("date-time")
timestamp Instant

@timestampFormat("date-time")
timestamp Date

