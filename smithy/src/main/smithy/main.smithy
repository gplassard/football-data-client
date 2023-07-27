$version: "2"

namespace footballdata


use aws.protocols#restJson1
use footballdata#AreaResource
use footballdata#CompetitionResource
use footballdata#MatchResource

@restJson1
@httpApiKeyAuth(name: "X-Auth-Token", in: "header")
service FootballData {
    version: "1.0"
    resources: [AreaResource, CompetitionResource, MatchResource]
    operations: []
}

@timestampFormat("date-time")
timestamp Instant

// https://smithy.io/2.0/spec/protocol-traits.html?highlight=date
// https://datatracker.ietf.org/doc/html/rfc3339.html#section-5.6
// @timestampFormat("date-time")
@pattern("^\\d{4}-\\d{2}-\\d{2}$")
string FullDate

